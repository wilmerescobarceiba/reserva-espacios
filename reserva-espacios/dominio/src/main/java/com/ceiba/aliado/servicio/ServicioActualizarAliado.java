package com.ceiba.aliado.servicio;

import com.ceiba.aliado.modelo.entidad.Aliado;
import com.ceiba.aliado.puerto.repositorio.RepositorioAliado;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAliado {

    private static final String EL_ALIADO_YA_EXISTE_EN_EL_SISTEMA = "El aliado ya existe en el sistema";

    private final RepositorioAliado repositorioAliado;

    public ServicioActualizarAliado(RepositorioAliado repositorioAliado) {
        this.repositorioAliado = repositorioAliado;
    }

    public void ejecutar(Aliado aliado) {
        if(this.repositorioAliado.existeExcluyendoId(aliado.getId(), aliado.getNombre())) {
            throw new ExcepcionDuplicidad(EL_ALIADO_YA_EXISTE_EN_EL_SISTEMA);
        }
        this.repositorioAliado.actualizar(aliado);
    }
}
