package com.ceiba.reserva.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Date fecha = resultSet.getDate("fecha");
        Long idaliado = resultSet.getLong("idaliado");
        Long idespacio = resultSet.getLong("idespacio");

        return new DtoReserva(id,fecha,idaliado ,idespacio);
    }

}
