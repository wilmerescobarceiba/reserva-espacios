package com.ceiba.categoria.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.categoria.consulta.ManejadorListarCategorias;
import com.ceiba.categoria.modelo.dto.DtoCategoria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/categoria")
@Api(tags={"Controlador consulta categoria"})
public class ConsultaControladorCategoria {

    private final ManejadorListarCategorias manejadorListarcategorias;

    public ConsultaControladorCategoria(ManejadorListarCategorias manejadorListarcategorias) {
        this.manejadorListarcategorias = manejadorListarcategorias;
    }

    @GetMapping
    @ApiOperation("Listar Categorias")
    public List<DtoCategoria> listar() {
        return this.manejadorListarcategorias.ejecutar();
    }

}
