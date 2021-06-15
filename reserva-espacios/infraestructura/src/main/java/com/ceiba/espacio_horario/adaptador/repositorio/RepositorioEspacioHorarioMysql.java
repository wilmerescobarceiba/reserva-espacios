package com.ceiba.espacio_horario.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.espacio_horario.modelo.entidad.EspacioHorario;
import com.ceiba.espacio_horario.puerto.repositorio.RepositorioEspacioHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;


@Repository
public class RepositorioEspacioHorarioMysql implements RepositorioEspacioHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="espacio_horario", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="espacio_horario", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="espacio_horario", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="espacio_horario", value="existe")
    private static String sqlExiste;

    public RepositorioEspacioHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(EspacioHorario espacioHorario) {
        return this.customNamedParameterJdbcTemplate.crear(espacioHorario, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long idhorario, Long idespacio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idhorario", idhorario);
        paramSource.addValue("idespacio", idespacio);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(EspacioHorario espacioHorario) {
        this.customNamedParameterJdbcTemplate.actualizar(espacioHorario, sqlActualizar);
    }
}
