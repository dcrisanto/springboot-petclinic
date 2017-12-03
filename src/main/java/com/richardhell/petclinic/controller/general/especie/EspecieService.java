package com.richardhell.petclinic.controller.general.especie;

import com.richardhell.petclinic.model.Especie;
import java.util.List;

public interface EspecieService {

    List<Especie> all();

    Especie find(Long id);

    void save(Especie especie);

    void delete(Long id);

}
