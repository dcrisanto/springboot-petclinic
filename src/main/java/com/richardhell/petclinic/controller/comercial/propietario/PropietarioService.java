package com.richardhell.petclinic.controller.comercial.propietario;

import com.richardhell.petclinic.model.Propietario;
import java.util.List;

public interface PropietarioService {

    List<Propietario> all();

    Propietario find(Long id);

    void save(Propietario propietario);

    void delete(Long id);

}
