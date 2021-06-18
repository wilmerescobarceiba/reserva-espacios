package com.ceiba.categoria.servicio;

import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCategoria {

    private static final String LA_CATEGORIA_YA_EXISTE_EN_EL_SISTEMA = "La categoria ya existe en el sistema";

    private final RepositorioCategoria repositorioCategoria;

    public ServicioActualizarCategoria(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    public void ejecutar(Categoria categoria) {
        if(this.repositorioCategoria.existeExcluyendoId(categoria.getId(),categoria.getNombre())) {
            throw new ExcepcionDuplicidad(LA_CATEGORIA_YA_EXISTE_EN_EL_SISTEMA);
        }
        this.repositorioCategoria.actualizar(categoria);
    }
}
