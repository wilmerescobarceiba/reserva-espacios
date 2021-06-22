package com.ceiba.reserva.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;

import org.junit.BeforeClass;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorReserva.class)
public class ComandoControladorReservaTest {

	private static int HORA_INICIO_CREACION_RESERVA = 7;
	private static int HORA_FINAL_CREACION_RESERVA = 17;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	private static ComandoReserva reserva;

	@BeforeClass
	public static void inicializar(){
		reserva = new ComandoReservaTestDataBuilder().build();
	}

	@Test
	public void testCrearReserva() throws Exception {

		int horaDelDia = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

		if (horaDelDia >= HORA_INICIO_CREACION_RESERVA && horaDelDia<= HORA_FINAL_CREACION_RESERVA) {
			mocMvc.perform(post("/reservas").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(reserva))).andExpect(status().isOk())
					.andExpect(content().json("{'valor': 1}"));
		}else{
			mocMvc.perform(post("/reservas").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(reserva))).andExpect(status().isBadRequest());
		}
	}

	@Test
	public void actualizarReserva() throws Exception {
		Long id = 10L;
		mocMvc.perform(put("/reservas/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(reserva))).andExpect(status().isOk());
	}

	@Test
	public void eliminarReserva() throws Exception {
		Long id = 1L;
		mocMvc.perform(
				delete("/reservas/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
