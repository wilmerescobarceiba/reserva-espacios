package com.ceiba.aliado.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.aliado.modelo.dto.DtoAliado;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoAliado implements RowMapper<DtoAliado>, MapperResult {

    @Override
    public DtoAliado mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nit = resultSet.getString("nit");
        String nombre = resultSet.getString("nombre");

        return new DtoAliado(id,nit,nombre);
    }

}
