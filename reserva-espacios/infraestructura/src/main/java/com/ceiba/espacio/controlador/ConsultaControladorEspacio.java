package com.ceiba.espacio.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.espacio.consulta.ManejadorListarEspacios;
import com.ceiba.espacio.modelo.dto.DtoEspacio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/espacio")
@Api(tags={"Controlador consulta espacio"})
public class ConsultaControladorEspacio {

    private final ManejadorListarEspacios manejadorListarespacios;

    public ConsultaControladorEspacio(ManejadorListarEspacios manejadorListarespacios) {
        this.manejadorListarespacios = manejadorListarespacios;
    }

    @GetMapping
    @ApiOperation("Listar Espacios")
    public List<DtoEspacio> listar() {
        return this.manejadorListarespacios.ejecutar();
    }

}
