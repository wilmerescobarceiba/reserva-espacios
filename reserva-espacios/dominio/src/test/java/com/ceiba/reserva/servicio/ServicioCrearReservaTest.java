package com.ceiba.reserva.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

public class ServicioCrearReservaTest {
    /*@Test
    public void validarClaveLongitudMenor4Test() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("124");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }*/

    @Test
    public void validarReservaExistenciaPreviaTest() {
        // arrange
    	Reserva reserva = new ReservaTestDataBuilder().conId(1l).build();
    	RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);        
        
        Mockito.when(repositorioReserva.existe(reserva.getFecha(), reserva.getIdespacio(), reserva.getIdhorario())).thenReturn(true);
        
        ServicioActualizarReserva servicioActuReserva = new ServicioActualizarReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActuReserva.ejecutar(reserva), ExcepcionDuplicidad.class,"La reserva ya existe en el sistema");
    }
}
