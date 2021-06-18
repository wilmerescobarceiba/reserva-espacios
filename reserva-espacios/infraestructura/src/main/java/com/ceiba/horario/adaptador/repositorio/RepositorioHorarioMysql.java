package com.ceiba.horario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioHorarioMysql implements RepositorioHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="horario", value="crear")
    private static String sqlCrearHorario;

    @SqlStatement(namespace="horario", value="actualizar")
    private static String sqlActualizarHorario;

    @SqlStatement(namespace="horario", value="eliminar")
    private static String sqlEliminarHorario;

    @SqlStatement(namespace="horario", value="existe")
    private static String sqlExisteHorario;

    @SqlStatement(namespace="horario", value="existeExcluyendoId") 
    private static String sqlExisteHorarioExcluyendoId;

    public RepositorioHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Horario horario) {
        return this.customNamedParameterJdbcTemplate.crear(horario, sqlCrearHorario);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarHorario, paramSource);
    }

    @Override
    public boolean existe(String hora) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("hora", hora);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteHorario,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Horario horario) {
        this.customNamedParameterJdbcTemplate.actualizar(horario, sqlActualizarHorario);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String hora) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("hora", hora);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteHorarioExcluyendoId,paramSource, Boolean.class);
    }
}
