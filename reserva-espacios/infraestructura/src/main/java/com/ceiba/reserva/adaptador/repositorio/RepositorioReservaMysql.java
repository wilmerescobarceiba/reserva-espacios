package com.ceiba.reserva.adaptador.repositorio;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;


@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="reserva", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="reserva", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="reserva", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="reserva", value="existe")
    private static String sqlExiste;
    
    @SqlStatement(namespace="reserva", value="reservas_dia")
    private static String reservasDia;
    
    @SqlStatement(namespace="reserva", value="reservasPorSemana") 
    private static String sqlReservasPorSemana;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Date fecha, Long idespacio, Long idhorario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();        
        paramSource.addValue("idespacio", idespacio);
        paramSource.addValue("idhorario", idhorario);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	
        paramSource.addValue("fecha", formatter.format(fecha));

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Reserva reserva) {
        this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizar);
    }

	@Override
	public Long cantidadReservasDia(Long idaliado, Long idespacio, Date fecha) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idaliado", idaliado);
        paramSource.addValue("idespacio", idespacio);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	
        paramSource.addValue("fecha", formatter.format(fecha));
       return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(reservasDia,paramSource, Long.class);
	}
	
	@Override
	public int obtenerReservasEnLaSemana(Long idespacio, Long idaliado, int anioReserva, int semanaAnioReserva, int dia) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idespacio", idespacio);
        paramSource.addValue("idaliado", idaliado);
        paramSource.addValue("anio", anioReserva);
        paramSource.addValue("semana", semanaAnioReserva);
        paramSource.addValue("dia", dia);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlReservasPorSemana,paramSource, Integer.class);
	}
}
