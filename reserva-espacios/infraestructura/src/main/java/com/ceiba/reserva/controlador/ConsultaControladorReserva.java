package com.ceiba.reserva.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.modelo.dto.DtoReserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reserva")
@Api(tags={"Controlador consulta reserva"})
public class ConsultaControladorReserva {

    private final ManejadorListarReservas manejadorListarreservas;

    public ConsultaControladorReserva(ManejadorListarReservas manejadorListarreservas) {
        this.manejadorListarreservas = manejadorListarreservas;
    }

    @GetMapping
    @ApiOperation("Listar Reservas")
    public List<DtoReserva> listar() {
        return this.manejadorListarreservas.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar Reserva por id")
    public DtoReserva buscar(@PathVariable Long id) {
        return this.manejadorListarreservas.buscar(id);
    }

}
