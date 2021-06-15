package com.ceiba.horario.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.comando.manejador.ManejadorActualizarHorario;
import com.ceiba.horario.comando.manejador.ManejadorCrearHorario;
import com.ceiba.horario.comando.manejador.ManejadorEliminarHorario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/horarios")
@Api(tags = { "Controlador comando horario"})
public class ComandoControladorHorario {

    private final ManejadorCrearHorario manejadorCrearHorario;
	private final ManejadorEliminarHorario manejadorEliminarHorario;
	private final ManejadorActualizarHorario manejadorActualizarHorario;

    @Autowired
    public ComandoControladorHorario(ManejadorCrearHorario manejadorCrearHorario,
									 ManejadorEliminarHorario manejadorEliminarHorario,
									 ManejadorActualizarHorario manejadorActualizarHorario) {
        this.manejadorCrearHorario = manejadorCrearHorario;
		this.manejadorEliminarHorario = manejadorEliminarHorario;
		this.manejadorActualizarHorario = manejadorActualizarHorario;
    }

    @PostMapping
    @ApiOperation("Crear Horario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoHorario comandoHorario) {
        return manejadorCrearHorario.ejecutar(comandoHorario);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Horario")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarHorario.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Horario")
	public void actualizar(@RequestBody ComandoHorario comandoHorario,@PathVariable Long id) {
		comandoHorario.setId(id);
		manejadorActualizarHorario.ejecutar(comandoHorario);
	}
}
