package com.ceiba.espacio_horario.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.espacio_horario.modelo.dto.DtoEspacioHorario;
import com.ceiba.espacio_horario.puerto.dao.DaoEspacioHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoEspacioHorarioMysql implements DaoEspacioHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="espacio_horario", value="listar")
    private static String sqlListar;

    public DaoEspacioHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEspacioHorario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEspacioHorario());
    }
}