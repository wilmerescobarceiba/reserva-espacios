package com.ceiba.aliado.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.aliado.modelo.dto.DtoAliado;
import com.ceiba.aliado.modelo.entidad.Aliado;
import com.ceiba.aliado.puerto.repositorio.RepositorioAliado;
import com.ceiba.aliado.servicio.testdatabuilder.AliadoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearAliadoTest {

	private Aliado aliado;
	private RepositorioAliado repositorioAliado;

	@Before
	public void inicializar() throws Exception {
		repositorioAliado = Mockito.mock(RepositorioAliado.class);
		aliado = new AliadoTestDataBuilder().build();
	}

	@Test
	public void validarAliadoExistenciaPreviaTest() {
		Mockito.when(repositorioAliado.existe(aliado.getNombre())).thenReturn(true);
		ServicioCrearAliado servicioCrearAliado = new ServicioCrearAliado(repositorioAliado);
		BasePrueba.assertThrows(() -> servicioCrearAliado.ejecutar(aliado), ExcepcionDuplicidad.class,
				"El aliado ya existe en el sistema");
	}

	@Test
	public void validarCreacionDto(){

		DtoAliado aliadoDto = new DtoAliado(1l, "123-abc", "nombre A");

		assertEquals(1l,aliadoDto.getId());
		assertEquals("123-abc",aliadoDto.getNit());
		assertEquals("nombre A", aliadoDto.getNombre());

	}
}
