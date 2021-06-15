package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.categoria.servicio.ServicioActualizarCategoria;
import com.ceiba.categoria.servicio.ServicioCrearCategoria;
import com.ceiba.categoria.servicio.ServicioEliminarCategoria;

@Configuration
public class BeanServicioCategoria {

    @Bean
    public ServicioCrearCategoria servicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
        return new ServicioCrearCategoria(repositorioCategoria);
    }

    @Bean
    public ServicioEliminarCategoria servicioEliminarCategoria(RepositorioCategoria repositorioCategoria) {
        return new ServicioEliminarCategoria(repositorioCategoria);
    }

    @Bean
    public ServicioActualizarCategoria servicioActualizarCategoria(RepositorioCategoria repositorioCategoria) {
        return new ServicioActualizarCategoria(repositorioCategoria);
    }
	

}
