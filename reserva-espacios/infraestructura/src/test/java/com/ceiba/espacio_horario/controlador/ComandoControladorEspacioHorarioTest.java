package com.ceiba.espacio_horario.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.espacio.servicio.testdatabuilder.ComandoEspacioTestDataBuilder;
import com.ceiba.espacio_horario.comando.ComandoEspacioHorario;
import com.ceiba.espacio_horario.servicio.testdatabuilder.ComandoEspacioHorarioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorEspacioHorario.class)
public class ComandoControladorEspacioHorarioTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testCrearEspacioHorario() throws Exception {
		ComandoEspacioHorario espacioHorario = new ComandoEspacioHorarioTestDataBuilder().build();

		mocMvc.perform(post("/espacio-horario").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(espacioHorario))).andExpect(status().isOk())
				.andExpect(jsonPath("$.valor").exists());
	}

	@Test
	public void actualizarEspacioHorario() throws Exception {
		Long id = 1L;
		ComandoEspacioHorario espacioHorario = new ComandoEspacioHorarioTestDataBuilder().build();

		mocMvc.perform(put("/espacio-horario/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(espacioHorario))).andExpect(status().isOk());
	}

	@Test
	public void eliminarEspacioHorario() throws Exception {
		Long id = 1L;
		mocMvc.perform(
				delete("/espacio-horario/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
