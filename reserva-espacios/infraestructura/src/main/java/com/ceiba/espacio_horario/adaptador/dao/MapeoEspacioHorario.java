package com.ceiba.espacio_horario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.espacio_horario.modelo.dto.DtoEspacioHorario;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoEspacioHorario implements RowMapper<DtoEspacioHorario>, MapperResult {

    @Override
    public DtoEspacioHorario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");        
        Long idhorario = resultSet.getLong("idhorario");
        Long idespacio = resultSet.getLong("idespacio");

        return new DtoEspacioHorario(id,idhorario ,idespacio);
    }

}
