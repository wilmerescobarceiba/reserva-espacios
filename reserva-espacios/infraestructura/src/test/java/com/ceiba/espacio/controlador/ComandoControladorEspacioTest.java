package com.ceiba.espacio.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.servicio.testdatabuilder.ComandoEspacioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorEspacio.class)
public class ComandoControladorEspacioTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testCrearEspacio() throws Exception {
		ComandoEspacio espacio = new ComandoEspacioTestDataBuilder().build();

		mocMvc.perform(post("/espacios").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(espacio))).andExpect(status().isOk())
				.andExpect(jsonPath("$.valor").exists());
	}

	@Test
	public void actualizarEspacio() throws Exception {
		Long id = 3L;
		ComandoEspacio Espacio = new ComandoEspacioTestDataBuilder().build();

		mocMvc.perform(put("/espacios/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(Espacio))).andExpect(status().isOk());
	}

	@Test
	public void eliminarEspacio() throws Exception {
		Long id = 3L;
		mocMvc.perform(
				delete("/espacios/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
