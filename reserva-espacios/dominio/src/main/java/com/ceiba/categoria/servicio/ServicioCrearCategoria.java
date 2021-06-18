package com.ceiba.categoria.servicio;

import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearCategoria {

    private static final String EL_CATEGORIA_YA_EXISTE_EN_EL_SISTEMA = "La categoria ya existe en el sistema";

    private final RepositorioCategoria repositorioCategoria;

    public ServicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    public Long ejecutar(Categoria categoria) {
        if(this.repositorioCategoria.existe(categoria.getNombre())) {
            throw new ExcepcionDuplicidad(EL_CATEGORIA_YA_EXISTE_EN_EL_SISTEMA);
        }
        return this.repositorioCategoria.crear(categoria);
    }
}
