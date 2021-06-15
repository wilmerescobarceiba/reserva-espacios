package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.aliado.puerto.repositorio.RepositorioAliado;
import com.ceiba.aliado.servicio.ServicioActualizarAliado;
import com.ceiba.aliado.servicio.ServicioCrearAliado;
import com.ceiba.aliado.servicio.ServicioEliminarAliado;

@Configuration
public class BeanServicioAliado {

    @Bean
    public ServicioCrearAliado servicioCrearAliado(RepositorioAliado repositorioAliado) {
        return new ServicioCrearAliado(repositorioAliado);
    }

    @Bean
    public ServicioEliminarAliado servicioEliminarAliado(RepositorioAliado repositorioAliado) {
        return new ServicioEliminarAliado(repositorioAliado);
    }

    @Bean
    public ServicioActualizarAliado servicioActualizarAliado(RepositorioAliado repositorioAliado) {
        return new ServicioActualizarAliado(repositorioAliado);
    }
	

}
