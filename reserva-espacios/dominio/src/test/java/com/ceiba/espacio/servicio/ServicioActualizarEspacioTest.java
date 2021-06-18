package com.ceiba.espacio.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.testdatabuilder.EspacioTestDataBuilder;

public class ServicioActualizarEspacioTest {
	
    @Test
    public void validarEspacioExistenciaPreviaTest() {
    	Espacio espacio = new EspacioTestDataBuilder().conId(1l).build();
    	RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);        
        
        Mockito.when(repositorioEspacio.existeExcluyendoId(espacio.getId(),espacio.getNombre())).thenReturn(true);
        
        ServicioActualizarEspacio servicioActuEspacio = new ServicioActualizarEspacio(repositorioEspacio);
        BasePrueba.assertThrows(() -> servicioActuEspacio.ejecutar(espacio), ExcepcionDuplicidad.class,"El espacio ya existe en el sistema");
    }
}
