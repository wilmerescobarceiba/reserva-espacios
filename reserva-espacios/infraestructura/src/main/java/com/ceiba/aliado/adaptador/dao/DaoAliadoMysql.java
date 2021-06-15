package com.ceiba.aliado.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.aliado.modelo.dto.DtoAliado;
import com.ceiba.aliado.puerto.dao.DaoAliado;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoAliadoMysql implements DaoAliado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="aliado", value="listar")
    private static String sqlListar;

    public DaoAliadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAliado> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAliado());
    }
}
