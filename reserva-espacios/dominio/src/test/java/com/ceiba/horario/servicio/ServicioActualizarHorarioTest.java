package com.ceiba.horario.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;

public class ServicioActualizarHorarioTest {
	
    @Test
    public void validarHorarioExistenciaPreviaTest() {
    	Horario horario = new HorarioTestDataBuilder().conId(1l).build();
    	RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);        
        
        Mockito.when(repositorioHorario.existeExcluyendoId(horario.getId(),horario.getHora())).thenReturn(true);
        
        ServicioActualizarHorario servicioActuHorario = new ServicioActualizarHorario(repositorioHorario);
        BasePrueba.assertThrows(() -> servicioActuHorario.ejecutar(horario), ExcepcionDuplicidad.class,"El horario ya existe en el sistema");
    }
}
