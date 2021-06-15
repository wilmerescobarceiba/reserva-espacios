package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.ServicioActualizarEspacio;
import com.ceiba.espacio.servicio.ServicioCrearEspacio;
import com.ceiba.espacio.servicio.ServicioEliminarEspacio;

@Configuration
public class BeanServicioEspacio {

    @Bean
    public ServicioCrearEspacio servicioCrearEspacio(RepositorioEspacio repositorioEspacio) {
        return new ServicioCrearEspacio(repositorioEspacio);
    }

    @Bean
    public ServicioEliminarEspacio servicioEliminarEspacio(RepositorioEspacio repositorioEspacio) {
        return new ServicioEliminarEspacio(repositorioEspacio);
    }

    @Bean
    public ServicioActualizarEspacio servicioActualizarEspacio(RepositorioEspacio repositorioEspacio) {
        return new ServicioActualizarEspacio(repositorioEspacio);
    }
	

}
