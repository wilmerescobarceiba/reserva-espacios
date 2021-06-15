package com.ceiba.espacio_horario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.espacio_horario.comando.ComandoEspacioHorario;
import com.ceiba.espacio_horario.comando.fabrica.FabricaEspacioHorario;
import com.ceiba.espacio_horario.modelo.entidad.EspacioHorario;
import com.ceiba.espacio_horario.servicio.ServicioCrearEspacioHorario;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearEspacioHorario implements ManejadorComandoRespuesta<ComandoEspacioHorario, ComandoRespuesta<Long>> {

    private final FabricaEspacioHorario fabricaEspacioHorario;
    private final ServicioCrearEspacioHorario servicioCrearEspacioHorario;

    public ManejadorCrearEspacioHorario(FabricaEspacioHorario fabricaEspacioHorario, ServicioCrearEspacioHorario servicioCrearEspacioHorario) {
        this.fabricaEspacioHorario = fabricaEspacioHorario;
        this.servicioCrearEspacioHorario = servicioCrearEspacioHorario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEspacioHorario comandoEspacioHorario) {
        EspacioHorario espacioHorario = this.fabricaEspacioHorario.crear(comandoEspacioHorario);
        return new ComandoRespuesta<>(this.servicioCrearEspacioHorario.ejecutar(espacioHorario));
    }
}