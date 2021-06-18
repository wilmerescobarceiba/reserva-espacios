package com.ceiba.espacio_horario.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.ApplicationMock;
import com.ceiba.espacio.controlador.ConsultaControladorEspacio;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorEspacio.class)
public class ConsultaControladorEspacioTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MockMvc mocMvc;
	
	@Before
	public void setUp() {
		this.mocMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

    @Test
    public void listar() throws Exception {
        mocMvc.perform(get("/espacio")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
