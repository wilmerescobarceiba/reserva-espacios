package com.ceiba.reserva.controlador;

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
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ComandoReservaTestDataBuilder;
import com.ceiba.usuario.controlador.ComandoControladorUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorUsuario.class)
public class ComandoControladorReservaTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testCrearReserva() throws Exception {
		ComandoReserva reserva = new ComandoReservaTestDataBuilder().build();

		mocMvc.perform(post("/reservas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(reserva))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 1}"));
	}

	@Test
	public void actualizarReserva() throws Exception {
		Long id = 1L;
		ComandoReserva Reserva = new ComandoReservaTestDataBuilder().build();

		mocMvc.perform(put("/reservas/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(Reserva))).andExpect(status().isOk());
	}

	@Test
	public void eliminarReserva() throws Exception {
		Long id = 1L;
		mocMvc.perform(
				delete("/reservas/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
