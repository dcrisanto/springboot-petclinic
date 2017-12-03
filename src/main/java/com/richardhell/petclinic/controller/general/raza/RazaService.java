package com.richardhell.petclinic.controller.general.raza;

import com.richardhell.petclinic.model.Especie;
import com.richardhell.petclinic.model.Raza;
import java.util.List;

public interface RazaService {

    List<Raza> all();

    List<Especie> allEspecie();
    
    Raza find(Long id);

    void save(Raza raza);

    void delete(Long id);

}
