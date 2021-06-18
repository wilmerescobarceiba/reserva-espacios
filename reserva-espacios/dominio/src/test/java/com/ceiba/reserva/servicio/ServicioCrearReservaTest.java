package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearReservaTest {

    private static SimpleDateFormat formatter;
    Date fecha;
    private Reserva reserva;
    private RepositorioReserva repositorioReserva;
    private RepositorioEspacio repositorioEspacio;
    private ServicioCrearReserva servicioCrearReserva;

    @BeforeClass
    public static void inicializarConstantes() {
        formatter = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Before
    public void inicializar() throws Exception {
        fecha = formatter.parse("2021-06-16");//Jueves
        repositorioReserva = Mockito.mock(RepositorioReserva.class);
        repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        reserva = new ReservaTestDataBuilder().conId(1l).conFecha(fecha).build();
        Mockito.when(repositorioReserva.obtenerHoraDelDia()).thenReturn(10); //10:00 AM
    }

    @Test
    public void validarReservaExistenciaPreviaTest() {
        Mockito.when(repositorioReserva.existe(reserva.getFecha(), reserva.getIdespacio(), reserva.getIdhorario())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, "La reserva ya existe en el sistema");
    }

    @Test
    public void validarCreacionDeReserva() {
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(1l);
        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        Assert.assertEquals(1l, servicioCrearReserva.ejecutar(reserva).longValue());
    }

    @Test
    public void validarTiempoMaximo5HPorDia() {
        Mockito.when(repositorioReserva.cantidadReservasDia(reserva.getIdaliado(), reserva.getIdespacio()
                , reserva.getFecha())).thenReturn(5l);
        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "Exedio la cantidad de reservas permitidas por día");
    }

    @Test
    public void validarReservaHoraAntesInicioOficina() {
        Mockito.when(repositorioReserva.obtenerHoraDelDia()).thenReturn(2);
        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "Las reservas solo se pueden hacer en horario de oficina");
    }

    @Test
    public void validarReservaHoraDespuesFinOficina() {
        Mockito.when(repositorioReserva.obtenerHoraDelDia()).thenReturn(18);
        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "Las reservas solo se pueden hacer en horario de oficina");
    }

    @Test
    public void validarCostoReservaDeUnaSolaHora() {
        Double costoEspacio = 10000d;

        Mockito.when(repositorioEspacio.obtenerCostoPorId(reserva.getIdespacio())).thenReturn(costoEspacio);
        Mockito.when(repositorioReserva.cantidadReservasDia(reserva.getIdaliado(),
                reserva.getIdespacio(), reserva.getFecha())).thenReturn(0l);//No tiene reserva

        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        Assert.assertEquals(servicioCrearReserva.calcularCostoTotal(reserva), costoEspacio);
    }

    @Test
    public void validarCostoReservaMasDeUnaHoraAlDia() {
        Double costoEspacio = 10000d;
        Double costoTotalReserva = 10500d; // cp + (cp * 5%)

        Mockito.when(repositorioEspacio.obtenerCostoPorId(reserva.getIdespacio())).thenReturn(costoEspacio);
        Mockito.when(repositorioReserva.cantidadReservasDia(reserva.getIdaliado(),
                reserva.getIdespacio(), reserva.getFecha())).thenReturn(1l);//Tiene al menos una hora ya reservada el mismo día

        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        Assert.assertEquals(servicioCrearReserva.calcularCostoTotal(reserva), costoTotalReserva);
    }

    @Test
    public void validarReservaMayorDosDiasUnaSolaHora() {
        Double costoEspacio = 10000d;
        Double costoTotalReserva = 11500d; // cp + (cp * 15%)

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reserva.getFecha());
        int semanaAnioReserva = calendar.get(Calendar.WEEK_OF_YEAR);
        int anioReserva = calendar.get(Calendar.YEAR);
        int dia = calendar.get(Calendar.DAY_OF_WEEK);

        Mockito.when(repositorioEspacio.obtenerCostoPorId(reserva.getIdespacio())).thenReturn(costoEspacio);
        Mockito.when(repositorioReserva.cantidadReservasDia(reserva.getIdaliado(),
                reserva.getIdespacio(), reserva.getFecha())).thenReturn(0l);//No tiene mas reservas el mismo día
        Mockito.when(repositorioReserva.obtenerReservasEnLaSemana(reserva.getIdespacio(),
                reserva.getIdaliado(), anioReserva, semanaAnioReserva, dia)).thenReturn(4); //Dia en el que se cobra costo adiconal

        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        Assert.assertEquals(costoTotalReserva, servicioCrearReserva.calcularCostoTotal(reserva));
    }


    @Test
    public void validarReservaMayorADosDiasMasDeUnaHoraAlDia() {
        Double costoEspacio = 10000d; //c + (c * 5%)
        Double costoTotalReserva = 12075d; // (cp + cp * 5%) + ((cp + cp * 5%) * 15%)

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reserva.getFecha());
        int semanaAnioReserva = calendar.get(Calendar.WEEK_OF_YEAR);
        int anioReserva = calendar.get(Calendar.YEAR);
        int dia = calendar.get(Calendar.DAY_OF_WEEK);

        Mockito.when(repositorioEspacio.obtenerCostoPorId(reserva.getIdespacio())).thenReturn(costoEspacio);
        Mockito.when(repositorioReserva.cantidadReservasDia(reserva.getIdaliado(),
                reserva.getIdespacio(), reserva.getFecha())).thenReturn(2l);//Tiene al menos una hora ya reservada el mismo día
        Mockito.when(repositorioReserva.obtenerReservasEnLaSemana(reserva.getIdespacio(),
                reserva.getIdaliado(), anioReserva, semanaAnioReserva, dia)).thenReturn(3); //Dia en el que se cobra costo adiconal

        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        Assert.assertEquals(costoTotalReserva, servicioCrearReserva.calcularCostoTotal(reserva));
    }

    @Test
    public void validarReservaFinDeSemana() throws Exception {
        fecha = formatter.parse("2021-06-19");//Sabado
        reserva = new ReservaTestDataBuilder().conId(1l).conFecha(fecha).build();

        Double costoEspacio = 10000d;
        Double costoTotal = 12000d; // ce + (ce * 20%)

        Mockito.when(repositorioEspacio.obtenerCostoPorId(reserva.getIdespacio())).thenReturn(costoEspacio);
        Mockito.when(repositorioReserva.cantidadReservasDia(reserva.getIdaliado(),
                reserva.getIdespacio(), reserva.getFecha())).thenReturn(0l);//No tiene reserva

        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioEspacio);
        Assert.assertEquals(costoTotal, servicioCrearReserva.calcularCostoTotal(reserva));
    }

    @Test
    public void validarCreacionDto(){
        DtoReserva reservaDto = new DtoReserva(
        1l,new Date(),1l,2l,10000d,3l);

        assertEquals(1l, reservaDto.getId().longValue());
        assertEquals(1l, reservaDto.getIdaliado().longValue());
        assertEquals(10000d, reservaDto.getCostototal().doubleValue());
        assertEquals(3l, reservaDto.getIdhorario().doubleValue());
    }
}
