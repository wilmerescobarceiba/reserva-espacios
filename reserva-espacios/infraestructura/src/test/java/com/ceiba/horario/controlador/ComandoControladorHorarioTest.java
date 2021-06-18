package com.ceiba.horario.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.servicio.testdatabuilder.ComandoHorarioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorHorario.class)
public class ComandoControladorHorarioTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testCrearHorario() throws Exception {
		ComandoHorario horario = new ComandoHorarioTestDataBuilder().build();

		mocMvc.perform(post("/horarios").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(horario))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));
	}

	@Test
	public void actualizarHorario() throws Exception {
		Long id = 2L;
		ComandoHorario Horario = new ComandoHorarioTestDataBuilder().build();

		mocMvc.perform(put("/horarios/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(Horario))).andExpect(status().isOk());
	}

	@Test
	public void eliminarHorario() throws Exception {
		Long id = 2L;
		mocMvc.perform(
				delete("/horarios/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
