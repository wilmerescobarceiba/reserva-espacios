package com.ceiba.espacio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorActualizarEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorCrearEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorEliminarEspacio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/espacios")
@Api(tags = { "Controlador comando espacio"})
public class ComandoControladorEspacio {

    private final ManejadorCrearEspacio manejadorCrearEspacio;
	private final ManejadorEliminarEspacio manejadorEliminarEspacio;
	private final ManejadorActualizarEspacio manejadorActualizarEspacio;

    @Autowired
    public ComandoControladorEspacio(ManejadorCrearEspacio manejadorCrearEspacio,
									 ManejadorEliminarEspacio manejadorEliminarEspacio,
									 ManejadorActualizarEspacio manejadorActualizarEspacio) {
        this.manejadorCrearEspacio = manejadorCrearEspacio;
		this.manejadorEliminarEspacio = manejadorEliminarEspacio;
		this.manejadorActualizarEspacio = manejadorActualizarEspacio;
    }

    @PostMapping
    @ApiOperation("Crear Espacio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEspacio comandoEspacio) {
        return manejadorCrearEspacio.ejecutar(comandoEspacio);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Espacio")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarEspacio.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Espacio")
	public void actualizar(@RequestBody ComandoEspacio comandoEspacio,@PathVariable Long id) {
		comandoEspacio.setId(id);
		manejadorActualizarEspacio.ejecutar(comandoEspacio);
	}
}
