package com.ceiba.espacio.servicio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.testdatabuilder.EspacioTestDataBuilder;

public class ServicioCrearEspacioTest {

	private Espacio espacio;
	private RepositorioEspacio repositorioEspacio;

	@Before
	public void inicializar() throws Exception {
		repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
		espacio = new EspacioTestDataBuilder().conId(1l).build();
	}

	@Test
	public void validarEspacioExistenciaPreviaTest() {
		Mockito.when(repositorioEspacio.existe(espacio.getNombre())).thenReturn(true);
		ServicioCrearEspacio servicioCrearEspacio = new ServicioCrearEspacio(repositorioEspacio);
		BasePrueba.assertThrows(() -> servicioCrearEspacio.ejecutar(espacio), ExcepcionDuplicidad.class,
				"El espacio ya existe en el sistema");
	}
}
