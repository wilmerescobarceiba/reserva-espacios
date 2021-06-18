package com.ceiba.aliado.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.aliado.modelo.entidad.Aliado;
import com.ceiba.aliado.puerto.repositorio.RepositorioAliado;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAliadoMysql implements RepositorioAliado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="aliado", value="crear")
    private static String sqlCrearAliado;

    @SqlStatement(namespace="aliado", value="actualizar")
    private static String sqlActualizarAliado;

    @SqlStatement(namespace="aliado", value="eliminar")
    private static String sqlEliminarAliado;

    @SqlStatement(namespace="aliado", value="existe")
    private static String sqlExisteAliado;

    @SqlStatement(namespace="aliado", value="existeExcluyendoId") 
    private static String sqlExisteAliadoExcluyendoId;

    public RepositorioAliadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Aliado aliado) {
        return this.customNamedParameterJdbcTemplate.crear(aliado, sqlCrearAliado);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarAliado, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteAliado,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Aliado aliado) {
        this.customNamedParameterJdbcTemplate.actualizar(aliado, sqlActualizarAliado);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteAliadoExcluyendoId,paramSource, Boolean.class);
    }
}
