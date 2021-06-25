package com.ceiba.espacio.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioEspacioMysql implements RepositorioEspacio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="espacio", value="crear")
    private static String sqlCrearEspacio;

    @SqlStatement(namespace="espacio", value="insertarEspacioHorario")
    private static String sqlInsertarEspacioHorario;

    @SqlStatement(namespace="espacio", value="actualizar")
    private static String sqlActualizarEspacio;

    @SqlStatement(namespace="espacio", value="eliminar")
    private static String sqlEliminarEspacio;

    @SqlStatement(namespace="espacio", value="existe")
    private static String sqlExisteEspacio;

    @SqlStatement(namespace="espacio", value="existeExcluyendoId") 
    private static String sqlExisteEspacioExcluyendoId;
    
    @SqlStatement(namespace="espacio", value="costoPorId") 
    private static String sqlCostoPorId;   

    public RepositorioEspacioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Espacio espacio) {
        Long id = this.customNamedParameterJdbcTemplate.crear(espacio, sqlCrearEspacio);
        insertarHorariosEnEspacio(id);
        return id;
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarEspacio, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteEspacio,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Espacio espacio) {
        this.customNamedParameterJdbcTemplate.actualizar(espacio, sqlActualizarEspacio);
    }


    private void insertarHorariosEnEspacio(Long idespacio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idespacio", idespacio);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlInsertarEspacioHorario, paramSource);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteEspacioExcluyendoId,paramSource, Boolean.class);
    }

	@Override
	public Double obtenerCostoPorId(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCostoPorId,paramSource, Double.class);
	}
}
