package com.ceiba.aliado.controlador;

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
import com.ceiba.aliado.comando.ComandoAliado;
import com.ceiba.aliado.servicio.testdatabuilder.ComandoAliadoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAliado.class)
public class ComandoControladorAliadoTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testCrearAliado() throws Exception {
		ComandoAliado aliado = new ComandoAliadoTestDataBuilder().build();

		mocMvc.perform(post("/aliados").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(aliado))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));
	}

	@Test
	public void testActualizarAliado() throws Exception {
		Long id = 2L;
		ComandoAliado aliado = new ComandoAliadoTestDataBuilder().build();

		mocMvc.perform(put("/aliados/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(aliado))).andExpect(status().isOk());
	}

	@Test
	public void testEliminarAliado() throws Exception {
		Long id = 2L;
		mocMvc.perform(
				delete("/aliados/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}	
}
