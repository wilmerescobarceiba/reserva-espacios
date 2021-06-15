package com.ceiba.categoria.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.categoria.comando.ComandoCategoria;
import com.ceiba.categoria.comando.manejador.ManejadorActualizarCategoria;
import com.ceiba.categoria.comando.manejador.ManejadorCrearCategoria;
import com.ceiba.categoria.comando.manejador.ManejadorEliminarCategoria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/categorias")
@Api(tags = { "Controlador comando categoria"})
public class ComandoControladorCategoria {

    private final ManejadorCrearCategoria manejadorCrearCategoria;
	private final ManejadorEliminarCategoria manejadorEliminarCategoria;
	private final ManejadorActualizarCategoria manejadorActualizarCategoria;

    @Autowired
    public ComandoControladorCategoria(ManejadorCrearCategoria manejadorCrearCategoria,
									 ManejadorEliminarCategoria manejadorEliminarCategoria,
									 ManejadorActualizarCategoria manejadorActualizarCategoria) {
        this.manejadorCrearCategoria = manejadorCrearCategoria;
		this.manejadorEliminarCategoria = manejadorEliminarCategoria;
		this.manejadorActualizarCategoria = manejadorActualizarCategoria;
    }

    @PostMapping
    @ApiOperation("Crear Categoria")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCategoria comandoCategoria) {
        return manejadorCrearCategoria.ejecutar(comandoCategoria);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Categoria")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarCategoria.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Categoria")
	public void actualizar(@RequestBody ComandoCategoria comandoCategoria,@PathVariable Long id) {
		comandoCategoria.setId(id);
		manejadorActualizarCategoria.ejecutar(comandoCategoria);
	}
}
