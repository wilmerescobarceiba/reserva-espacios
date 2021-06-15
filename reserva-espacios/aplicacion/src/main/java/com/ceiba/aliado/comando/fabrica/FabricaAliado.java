package com.ceiba.aliado.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.aliado.comando.ComandoAliado;
import com.ceiba.aliado.modelo.entidad.Aliado;

@Component
public class FabricaAliado {

    public Aliado crear(ComandoAliado comandoAliado) {
        return new Aliado(
        		comandoAliado.getId(),
        		comandoAliado.getNit(),
        		comandoAliado.getNombre()
        );
    }

}
