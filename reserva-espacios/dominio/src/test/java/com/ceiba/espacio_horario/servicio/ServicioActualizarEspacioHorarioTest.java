package com.ceiba.espacio_horario.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio_horario.modelo.entidad.EspacioHorario;
import com.ceiba.espacio_horario.puerto.repositorio.RepositorioEspacioHorario;
import com.ceiba.espacio_horario.servicio.testdatabuilder.EspacioHorarioTestDataBuilder;

public class ServicioActualizarEspacioHorarioTest {
	
    @Test
    public void validarEspacioHorarioExistenciaPreviaTest() {
    	EspacioHorario espacioHorario = new EspacioHorarioTestDataBuilder().conId(1l).build();
    	RepositorioEspacioHorario repositorioEspacioHorario = Mockito.mock(RepositorioEspacioHorario.class);        
        
        Mockito.when(repositorioEspacioHorario.existe(espacioHorario.getIdespacio(), espacioHorario.getIdhorario())).thenReturn(true);
        
        ServicioActualizarEspacioHorario servicioActuEspacioHorario = new ServicioActualizarEspacioHorario(repositorioEspacioHorario);
        BasePrueba.assertThrows(() -> servicioActuEspacioHorario.ejecutar(espacioHorario), ExcepcionDuplicidad.class,"El espacioHorario ya existe en el sistema");
    }
}
