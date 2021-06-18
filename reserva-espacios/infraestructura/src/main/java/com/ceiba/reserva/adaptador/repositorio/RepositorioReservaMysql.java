package com.ceiba.reserva.adaptador.repositorio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;


@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private static final String FECHA_LABEL = "fecha";

	private static final String ID_ALIADO_LABEL = "idaliado";

	private static final String ID_ESPACIO_LABEL = "idespacio";

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="reserva", value="crear")
    private static String sqlCrearReservar;

    @SqlStatement(namespace="reserva", value="actualizar")
    private static String sqlActualizarReservar;

    @SqlStatement(namespace="reserva", value="eliminar")
    private static String sqlEliminarReservar;

    @SqlStatement(namespace="reserva", value="existe")
    private static String sqlExisteReservar;
    
    @SqlStatement(namespace="reserva", value="reservas_dia")
    private static String reservasDiaReservar;
    
    @SqlStatement(namespace="reserva", value="reservasPorSemana") 
    private static String sqlReservasPorSemanaReservar;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrearReservar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarReservar, paramSource);
    }

    @Override
    public boolean existe(Date fecha, Long idespacio, Long idhorario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();        
        paramSource.addValue(ID_ESPACIO_LABEL, idespacio);
        paramSource.addValue("idhorario", idhorario);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	
        paramSource.addValue(FECHA_LABEL, formatter.format(fecha));

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteReservar,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Reserva reserva) {
        this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizarReservar);
    }

	@Override
	public Long cantidadReservasDia(Long idaliado, Long idespacio, Date fecha) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_ALIADO_LABEL, idaliado);
        paramSource.addValue(ID_ESPACIO_LABEL, idespacio);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	
        paramSource.addValue(FECHA_LABEL, formatter.format(fecha));
       return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(reservasDiaReservar,paramSource, Long.class);
	}
	
	@Override
	public int obtenerReservasEnLaSemana(Long idespacio, Long idaliado, int anioReserva, int semanaAnioReserva, int dia) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_ESPACIO_LABEL, idespacio);
        paramSource.addValue(ID_ALIADO_LABEL, idaliado);
        paramSource.addValue("anio", anioReserva);
        paramSource.addValue("semana", semanaAnioReserva);
        paramSource.addValue("dia", dia);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlReservasPorSemanaReservar,paramSource, Integer.class);
	}

    @Override
    public int obtenerHoraDelDia() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }
}
