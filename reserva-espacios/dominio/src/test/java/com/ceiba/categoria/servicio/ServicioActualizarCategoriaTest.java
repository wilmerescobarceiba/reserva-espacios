package com.ceiba.categoria.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.categoria.servicio.testdatabuilder.CategoriaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCategoriaTest {
	
    @Test
    public void validarCategoriaExistenciaPreviaTest() {
    	Categoria categoria = new CategoriaTestDataBuilder().conId(1l).build();
    	RepositorioCategoria repositorioCategoria = Mockito.mock(RepositorioCategoria.class);        
        
        Mockito.when(repositorioCategoria.existeExcluyendoId(categoria.getId(),categoria.getNombre())).thenReturn(true);
        
        ServicioActualizarCategoria servicioActuCategoria = new ServicioActualizarCategoria(repositorioCategoria);
        BasePrueba.assertThrows(() -> servicioActuCategoria.ejecutar(categoria), ExcepcionDuplicidad.class,"La categoria ya existe en el sistema");
    }
}
