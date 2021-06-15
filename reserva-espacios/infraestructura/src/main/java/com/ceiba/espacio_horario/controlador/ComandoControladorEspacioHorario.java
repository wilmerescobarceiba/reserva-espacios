package com.ceiba.espacio_horario.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.espacio_horario.comando.ComandoEspacioHorario;
import com.ceiba.espacio_horario.comando.manejador.ManejadorActualizarEspacioHorario;
import com.ceiba.espacio_horario.comando.manejador.ManejadorCrearEspacioHorario;
import com.ceiba.espacio_horario.comando.manejador.ManejadorEliminarEspacioHorario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/espacio-horario")
@Api(tags = { "Controlador comando espacioHorario"})
public class ComandoControladorEspacioHorario {

    private final ManejadorCrearEspacioHorario manejadorCrearEspacioHorario;
	private final ManejadorEliminarEspacioHorario manejadorEliminarEspacioHorario;
	private final ManejadorActualizarEspacioHorario manejadorActualizarEspacioHorario;

    @Autowired
    public ComandoControladorEspacioHorario(ManejadorCrearEspacioHorario manejadorCrearEspacioHorario,
									 ManejadorEliminarEspacioHorario manejadorEliminarEspacioHorario,
									 ManejadorActualizarEspacioHorario manejadorActualizarEspacioHorario) {
        this.manejadorCrearEspacioHorario = manejadorCrearEspacioHorario;
		this.manejadorEliminarEspacioHorario = manejadorEliminarEspacioHorario;
		this.manejadorActualizarEspacioHorario = manejadorActualizarEspacioHorario;
    }

    @PostMapping
    @ApiOperation("Crear EspacioHorario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEspacioHorario comandoEspacioHorario) {
        return manejadorCrearEspacioHorario.ejecutar(comandoEspacioHorario);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar EspacioHorario")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarEspacioHorario.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar EspacioHorario")
	public void actualizar(@RequestBody ComandoEspacioHorario comandoEspacioHorario,@PathVariable Long id) {
		comandoEspacioHorario.setId(id);
		manejadorActualizarEspacioHorario.ejecutar(comandoEspacioHorario);
	}
}