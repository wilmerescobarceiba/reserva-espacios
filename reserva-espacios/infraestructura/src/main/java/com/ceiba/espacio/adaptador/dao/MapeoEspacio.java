package com.ceiba.espacio.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoEspacio implements RowMapper<DtoEspacio>, MapperResult {

    @Override
    public DtoEspacio mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String codigo = resultSet.getString("codigo");
        String nombre = resultSet.getString("nombre");
    	String descripcion = resultSet.getString("descripcion");
    	Integer capacidad = resultSet.getInt("capacidad");
    	Double costo = resultSet.getDouble("costo");
    	String fotografia = resultSet.getString("fotografia");
    	Long idcategoria = resultSet.getLong("idcategoria");    	
    	
        return new DtoEspacio(id,codigo,nombre , descripcion, capacidad, costo, fotografia, idcategoria);
    }

}
