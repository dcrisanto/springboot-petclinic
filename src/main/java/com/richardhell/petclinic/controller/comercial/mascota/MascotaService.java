package com.richardhell.petclinic.controller.comercial.mascota;

import com.richardhell.petclinic.model.Especie;
import com.richardhell.petclinic.model.Mascota;
import com.richardhell.petclinic.model.Propietario;
import com.richardhell.petclinic.model.Raza;
import java.util.List;

public interface MascotaService {

    List<Mascota> all();

    Mascota find(Long id);

    void save(Mascota mascota);

    void delete(Long id);

    public List<Especie> allEspecie();

    public List<Raza> allRaza();

    public List<Propietario> allPropietario();

    public List<Mascota> allByPropietario(Propietario prop);

    public Propietario findPropietario(Long propietario);

}
