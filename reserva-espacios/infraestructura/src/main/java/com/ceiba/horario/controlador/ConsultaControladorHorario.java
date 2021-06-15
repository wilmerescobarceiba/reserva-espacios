package com.ceiba.horario.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.horario.consulta.ManejadorListarHorarios;
import com.ceiba.horario.modelo.dto.DtoHorario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/horario")
@Api(tags={"Controlador consulta horario"})
public class ConsultaControladorHorario {

    private final ManejadorListarHorarios manejadorListarhorarios;

    public ConsultaControladorHorario(ManejadorListarHorarios manejadorListarhorarios) {
        this.manejadorListarhorarios = manejadorListarhorarios;
    }

    @GetMapping
    @ApiOperation("Listar Horarios")
    public List<DtoHorario> listar() {
        return this.manejadorListarhorarios.ejecutar();
    }

}
