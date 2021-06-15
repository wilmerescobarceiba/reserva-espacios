package com.ceiba.espacio.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.modelo.entidad.Espacio;

@Component
public class FabricaEspacio {

    public Espacio crear(ComandoEspacio comandoEspacio) {
        return new Espacio(
        		comandoEspacio.getId(),
        		comandoEspacio.getCodigo(),
        		comandoEspacio.getNombre(),
        		comandoEspacio.getDescripcion(),
        		comandoEspacio.getCapacidad(),
        		comandoEspacio.getFotografia(),
        		comandoEspacio.getCosto(),        		
        		comandoEspacio.getIdcategoria()
        );
    }

}
