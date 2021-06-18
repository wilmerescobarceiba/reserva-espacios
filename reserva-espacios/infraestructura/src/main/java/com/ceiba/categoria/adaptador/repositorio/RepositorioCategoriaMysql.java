package com.ceiba.categoria.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoriaMysql implements RepositorioCategoria {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="categoria", value="crear")
    private static String sqlCrearCategoria;

    @SqlStatement(namespace="categoria", value="actualizar")
    private static String sqlActualizarCategoria;

    @SqlStatement(namespace="categoria", value="eliminar")
    private static String sqlEliminarCategoria;

    @SqlStatement(namespace="categoria", value="existe")
    private static String sqlExisteCategoria;

    @SqlStatement(namespace="categoria", value="existeExcluyendoId") 
    private static String sqlExisteCategoriaExcluyendoId;

    public RepositorioCategoriaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Categoria categoria) {
        return this.customNamedParameterJdbcTemplate.crear(categoria, sqlCrearCategoria);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarCategoria, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCategoria,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Categoria categoria) {
        this.customNamedParameterJdbcTemplate.actualizar(categoria, sqlActualizarCategoria);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCategoriaExcluyendoId,paramSource, Boolean.class);
    }
}
