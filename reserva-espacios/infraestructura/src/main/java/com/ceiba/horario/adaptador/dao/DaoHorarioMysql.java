package com.ceiba.horario.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.puerto.dao.DaoHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoHorarioMysql implements DaoHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="horario", value="listar")
    private static String sqlListar;

    public DaoHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoHorario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoHorario());
    }
}
