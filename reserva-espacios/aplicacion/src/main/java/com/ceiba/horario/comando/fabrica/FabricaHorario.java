package com.ceiba.horario.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.modelo.entidad.Horario;

@Component
public class FabricaHorario {

    public Horario crear(ComandoHorario comandoHorario) {
        return new Horario(
        		comandoHorario.getId(),
        		comandoHorario.getHora().value
        );
    }

}
