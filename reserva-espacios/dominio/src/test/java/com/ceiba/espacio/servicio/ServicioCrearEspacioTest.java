package com.ceiba.espacio.servicio;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.servicio.testdatabuilder.HoraType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.testdatabuilder.EspacioTestDataBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	public void validarCreacionDto(){

		DtoEspacio espacioDto = new DtoEspacio(1l, "codigo A", "nombre A", "descripcion A",
				10, 10000d,"base64...",1l);

		assertEquals(1l,espacioDto.getId());
		assertEquals("codigo A",espacioDto.getCodigo());
		assertEquals("nombre A", espacioDto.getNombre());
		assertEquals("descripcion A", espacioDto.getDescripcion());
		assertEquals(10, espacioDto.getCapacidad());
		assertEquals(10000d,espacioDto.getCosto());
		assertEquals("base64...",espacioDto.getFotografia());
		assertEquals(1l,espacioDto.getIdcategoria());

	}
}
