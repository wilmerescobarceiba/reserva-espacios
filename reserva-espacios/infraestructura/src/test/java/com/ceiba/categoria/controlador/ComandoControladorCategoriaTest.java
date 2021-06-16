package com.ceiba.categoria.controlador;

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
import com.ceiba.categoria.comando.ComandoCategoria;
import com.ceiba.categoria.servicio.testdatabuilder.ComandoCategoriaTestDataBuilder;
import com.ceiba.usuario.controlador.ComandoControladorUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorUsuario.class)
public class ComandoControladorCategoriaTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testCrearCategoria() throws Exception {
		ComandoCategoria categoria = new ComandoCategoriaTestDataBuilder().build();

		mocMvc.perform(post("/categorias").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(categoria))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));
	}

	@Test
	public void testActualizarCategoria() throws Exception {
		Long id = 2L;
		ComandoCategoria categoria = new ComandoCategoriaTestDataBuilder().build();

		mocMvc.perform(put("/categorias/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(categoria))).andExpect(status().isOk());
	}

	@Test
	public void testEliminarCategoria() throws Exception {
		Long id = 2L;
		mocMvc.perform(
				delete("/categorias/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}	
}
