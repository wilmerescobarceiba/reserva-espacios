package com.ceiba.aliado.puerto.repositorio;

import com.ceiba.aliado.modelo.entidad.Aliado;

public interface RepositorioAliado {
    /**
     * Permite crear un aliado
     * @param aliado
     * @return el id generado
     */
    Long crear(Aliado aliado);

    /**
     * Permite actualizar un aliado
     * @param aliado
     */
    void actualizar(Aliado aliado);

    /**
     * Permite eliminar un aliado
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un aliado con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un aliado con un  excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombre);
}
