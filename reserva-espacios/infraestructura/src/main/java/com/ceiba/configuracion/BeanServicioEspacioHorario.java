package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.espacio_horario.puerto.repositorio.RepositorioEspacioHorario;
import com.ceiba.espacio_horario.servicio.ServicioActualizarEspacioHorario;
import com.ceiba.espacio_horario.servicio.ServicioCrearEspacioHorario;
import com.ceiba.espacio_horario.servicio.ServicioEliminarEspacioHorario;

@Configuration
public class BeanServicioEspacioHorario {

    @Bean
    public ServicioCrearEspacioHorario servicioCrearEspacioHorario(RepositorioEspacioHorario repositorioEspacioHorario) {
        return new ServicioCrearEspacioHorario(repositorioEspacioHorario);
    }

    @Bean
    public ServicioEliminarEspacioHorario servicioEliminarEspacioHorario(RepositorioEspacioHorario repositorioEspacioHorario) {
        return new ServicioEliminarEspacioHorario(repositorioEspacioHorario);
    }

    @Bean
    public ServicioActualizarEspacioHorario servicioActualizarEspacioHorario(RepositorioEspacioHorario repositorioEspacioHorario) {
        return new ServicioActualizarEspacioHorario(repositorioEspacioHorario);
    }
	

}
