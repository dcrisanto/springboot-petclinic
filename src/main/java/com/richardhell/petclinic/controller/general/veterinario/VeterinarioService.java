package com.richardhell.petclinic.controller.general.veterinario;

import com.richardhell.petclinic.model.Veterinario;
import java.util.List;

public interface VeterinarioService {

    List<Veterinario> all();

    Veterinario find(Long id);

    void save(Veterinario veterinario);

    void delete(Long id);

}
