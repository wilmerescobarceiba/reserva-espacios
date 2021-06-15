package com.ceiba.reserva.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorActualizarReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reserva.comando.manejador.ManejadorEliminarReserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reservas")
@Api(tags = { "Controlador comando reserva"})
public class ComandoControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
	private final ManejadorEliminarReserva manejadorEliminarReserva;
	private final ManejadorActualizarReserva manejadorActualizarReserva;

    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva,
									 ManejadorEliminarReserva manejadorEliminarReserva,
									 ManejadorActualizarReserva manejadorActualizarReserva) {
        this.manejadorCrearReserva = manejadorCrearReserva;
		this.manejadorEliminarReserva = manejadorEliminarReserva;
		this.manejadorActualizarReserva = manejadorActualizarReserva;
    }

    @PostMapping
    @ApiOperation("Crear Reserva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva) {
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Reserva")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarReserva.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Reserva")
	public void actualizar(@RequestBody ComandoReserva comandoReserva,@PathVariable Long id) {
		comandoReserva.setId(id);
		manejadorActualizarReserva.ejecutar(comandoReserva);
	}
}