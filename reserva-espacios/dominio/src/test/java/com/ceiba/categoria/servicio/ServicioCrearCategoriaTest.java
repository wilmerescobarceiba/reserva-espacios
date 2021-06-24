package com.ceiba.categoria.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.categoria.modelo.dto.DtoCategoria;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.categoria.servicio.testdatabuilder.CategoriaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	public void validarCrearCategoriaTest() {
		Mockito.when(repositorioCategoria.existe(categoria.getNombre())).thenReturn(false);
		Mockito.when(repositorioCategoria.crear(categoria)).thenReturn(1l);

		ServicioCrearCategoria servicioCrearCategoria = new ServicioCrearCategoria(repositorioCategoria);
		Assert.assertEquals(1l, servicioCrearCategoria.ejecutar(categoria).longValue());
	}

	@Test
	public void validarCreacionDto(){

		DtoCategoria categoriaDto = new DtoCategoria(1l, "codigo A", "nombre A", "base64...");

		assertEquals(1l,categoriaDto.getId());
		assertEquals("codigo A",categoriaDto.getCodigo());
		assertEquals("nombre A", categoriaDto.getNombre());
		assertEquals("base64...",categoriaDto.getFotografia());

	}
}
