package com.ceiba.aliado.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.aliado.comando.ComandoAliado;
import com.ceiba.aliado.comando.manejador.ManejadorActualizarAliado;
import com.ceiba.aliado.comando.manejador.ManejadorCrearAliado;
import com.ceiba.aliado.comando.manejador.ManejadorEliminarAliado;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aliados")
@Api(tags = { "Controlador comando aliado"})
public class ComandoControladorAliado {

    private final ManejadorCrearAliado manejadorCrearAliado;
	private final ManejadorEliminarAliado manejadorEliminarAliado;
	private final ManejadorActualizarAliado manejadorActualizarAliado;

    @Autowired
    public ComandoControladorAliado(ManejadorCrearAliado manejadorCrearAliado,
									 ManejadorEliminarAliado manejadorEliminarAliado,
									 ManejadorActualizarAliado manejadorActualizarAliado) {
        this.manejadorCrearAliado = manejadorCrearAliado;
		this.manejadorEliminarAliado = manejadorEliminarAliado;
		this.manejadorActualizarAliado = manejadorActualizarAliado;
    }

    @PostMapping
    @ApiOperation("Crear Aliado")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAliado comandoAliado) {
        return manejadorCrearAliado.ejecutar(comandoAliado);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Aliado")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarAliado.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Aliado")
	public void actualizar(@RequestBody ComandoAliado comandoAliado,@PathVariable Long id) {
		comandoAliado.setId(id);
		manejadorActualizarAliado.ejecutar(comandoAliado);
	}
}
