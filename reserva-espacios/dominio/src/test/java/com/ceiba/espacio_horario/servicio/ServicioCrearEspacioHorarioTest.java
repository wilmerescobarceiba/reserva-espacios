package com.ceiba.espacio_horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio_horario.modelo.dto.DtoEspacioHorario;
import com.ceiba.espacio_horario.modelo.entidad.EspacioHorario;
import com.ceiba.espacio_horario.puerto.repositorio.RepositorioEspacioHorario;
import com.ceiba.espacio_horario.servicio.testdatabuilder.EspacioHorarioTestDataBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearEspacioHorarioTest {

	private EspacioHorario espacioHorario;
	private RepositorioEspacioHorario repositorioEspacioHorario;

	@Before
	public void inicializar() throws Exception {
		repositorioEspacioHorario = Mockito.mock(RepositorioEspacioHorario.class);
		espacioHorario = new EspacioHorarioTestDataBuilder().conId(1l).build();
	}

	@Test
	public void validarEspacioExistenciaPreviaTest() {
		Mockito.when(repositorioEspacioHorario.existe(espacioHorario.getIdhorario(), espacioHorario.getIdespacio())).thenReturn(true);
		ServicioCrearEspacioHorario servicioCrearEspacioHorario = new ServicioCrearEspacioHorario(repositorioEspacioHorario);
		BasePrueba.assertThrows(() -> servicioCrearEspacioHorario.ejecutar(espacioHorario), ExcepcionDuplicidad.class,
				"El espacioHorario ya existe en el sistema");
	}

	@Test
	public void validarCreaEspacioHorarioTest() {
		Mockito.when(repositorioEspacioHorario.existe(espacioHorario.getIdhorario(), espacioHorario.getIdespacio())).thenReturn(false);
		Mockito.when(repositorioEspacioHorario.crear(espacioHorario)).thenReturn(1l);

		ServicioCrearEspacioHorario servicioCrearEspacioHorario = new ServicioCrearEspacioHorario(repositorioEspacioHorario);
		Assert.assertEquals(1l, servicioCrearEspacioHorario.ejecutar(espacioHorario).longValue());
	}

	@Test
	public void validarCreacionDto(){
		DtoEspacioHorario espacioHorarioDto = new DtoEspacioHorario(1l,1l,1l);

		assertEquals(1l, espacioHorarioDto.getId());
		assertEquals(1l, espacioHorarioDto.getIdHorario());
		assertEquals(1l, espacioHorarioDto.getIdEspacio());
	}
}
