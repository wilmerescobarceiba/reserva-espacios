package com.ceiba.aliado.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.aliado.consulta.ManejadorListarAliados;
import com.ceiba.aliado.modelo.dto.DtoAliado;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aliado")
@Api(tags={"Controlador consulta aliado"})
public class ConsultaControladorAliado {

    private final ManejadorListarAliados manejadorListaraliados;

    public ConsultaControladorAliado(ManejadorListarAliados manejadorListaraliados) {
        this.manejadorListaraliados = manejadorListaraliados;
    }

    @GetMapping
    @ApiOperation("Listar Aliados")
    public List<DtoAliado> listar() {
        return this.manejadorListaraliados.ejecutar();
    }

}
