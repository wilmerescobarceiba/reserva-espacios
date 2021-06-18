package com.ceiba.horario.servicio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;

public class ServicioCrearHorarioTest {

	private Horario horario;
	private RepositorioHorario repositorioHorario;

	@Before
	public void inicializar() throws Exception {
		repositorioHorario = Mockito.mock(RepositorioHorario.class);
		horario = new HorarioTestDataBuilder().conId(1l).build();
	}

	@Test
	public void validarHorarioExistenciaPreviaTest() {
		Mockito.when(repositorioHorario.existe(horario.getHora())).thenReturn(true);
		ServicioCrearHorario servicioCrearHorario = new ServicioCrearHorario(repositorioHorario);
		BasePrueba.assertThrows(() -> servicioCrearHorario.ejecutar(horario), ExcepcionDuplicidad.class,
				"El horario ya existe en el sistema");
	}
}
