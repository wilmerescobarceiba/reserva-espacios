package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.ServicioActualizarHorario;
import com.ceiba.horario.servicio.ServicioCrearHorario;
import com.ceiba.horario.servicio.ServicioEliminarHorario;

@Configuration
public class BeanServicioHorario {

    @Bean
    public ServicioCrearHorario servicioCrearHorario(RepositorioHorario repositorioHorario) {
        return new ServicioCrearHorario(repositorioHorario);
    }

    @Bean
    public ServicioEliminarHorario servicioEliminarHorario(RepositorioHorario repositorioHorario) {
        return new ServicioEliminarHorario(repositorioHorario);
    }

    @Bean
    public ServicioActualizarHorario servicioActualizarHorario(RepositorioHorario repositorioHorario) {
        return new ServicioActualizarHorario(repositorioHorario);
    }
	

}
