package com.ceiba.aliado.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.aliado.modelo.entidad.Aliado;
import com.ceiba.aliado.puerto.repositorio.RepositorioAliado;
import com.ceiba.aliado.servicio.testdatabuilder.AliadoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAliadoTest {
	
    @Test
    public void validarAliadoExistenciaPreviaTest() {
    	Aliado aliado = new AliadoTestDataBuilder().build();
    	RepositorioAliado repositorioAliado = Mockito.mock(RepositorioAliado.class);        
        
        Mockito.when(repositorioAliado.existeExcluyendoId(aliado.getId(),aliado.getNombre())).thenReturn(true);
        
        ServicioActualizarAliado servicioActuAliado = new ServicioActualizarAliado(repositorioAliado);
        BasePrueba.assertThrows(() -> servicioActuAliado.ejecutar(aliado), ExcepcionDuplicidad.class,"El aliado ya existe en el sistema");
    }
}
