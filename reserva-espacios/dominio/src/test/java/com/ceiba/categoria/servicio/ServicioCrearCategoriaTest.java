package com.ceiba.categoria.servicio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.categoria.servicio.testdatabuilder.CategoriaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCategoriaTest {

	private Categoria categoria;
	private RepositorioCategoria repositorioCategoria;

	@Before
	public void inicializar() throws Exception {
		repositorioCategoria = Mockito.mock(RepositorioCategoria.class);
		categoria = new CategoriaTestDataBuilder().conId(1l).build();
	}

	@Test
	public void validarCategoriaExistenciaPreviaTest() {
		Mockito.when(repositorioCategoria.existe(categoria.getNombre())).thenReturn(true);
		ServicioCrearCategoria servicioCrearCategoria = new ServicioCrearCategoria(repositorioCategoria);
		BasePrueba.assertThrows(() -> servicioCrearCategoria.ejecutar(categoria), ExcepcionDuplicidad.class,
				"La categoria ya existe en el sistema");
	}
}
