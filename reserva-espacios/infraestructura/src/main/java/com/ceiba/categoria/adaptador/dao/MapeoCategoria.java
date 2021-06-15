package com.ceiba.categoria.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.categoria.modelo.dto.DtoCategoria;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoCategoria implements RowMapper<DtoCategoria>, MapperResult {

    @Override
    public DtoCategoria mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String codigo = resultSet.getString("codigo");
        String nombre = resultSet.getString("nombre");
        String fotografia = resultSet.getString("fotografia");

        return new DtoCategoria(id,codigo,nombre ,fotografia);
    }

}
