package com.ceiba.horario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoHorario implements RowMapper<DtoHorario>, MapperResult {

    @Override
    public DtoHorario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String hora = resultSet.getString("hora");

        return new DtoHorario(id,hora);
    }

}
