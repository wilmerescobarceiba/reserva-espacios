package com.ceiba.espacio_horario.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.espacio_horario.consulta.ManejadorListarEspacioHorarios;
import com.ceiba.espacio_horario.modelo.dto.DtoEspacioHorario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/espacio-horario")
@Api(tags={"Controlador consulta espacioHorario"})
public class ConsultaControladorEspacioHorario {

    private final ManejadorListarEspacioHorarios manejadorListarespacioHorarios;

    public ConsultaControladorEspacioHorario(ManejadorListarEspacioHorarios manejadorListarespacioHorarios) {
        this.manejadorListarespacioHorarios = manejadorListarespacioHorarios;
    }

    @GetMapping
    @ApiOperation("Listar EspacioHorarios")
    public List<DtoEspacioHorario> listar() {
        return this.manejadorListarespacioHorarios.ejecutar();
    }

}
