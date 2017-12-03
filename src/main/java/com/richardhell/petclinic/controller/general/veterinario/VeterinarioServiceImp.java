package com.richardhell.petclinic.controller.general.veterinario;

import com.richardhell.petclinic.dao.PersonaDAO;
import com.richardhell.petclinic.dao.VeterinarioDAO;
import com.richardhell.petclinic.model.Persona;
import com.richardhell.petclinic.model.Veterinario;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VeterinarioServiceImp implements VeterinarioService {

    @Autowired
    VeterinarioDAO veterinarioDAO;

    @Autowired
    PersonaDAO personaDAO;

    public List<Veterinario> all() {
        return veterinarioDAO.all();
    }

    public Veterinario find(Long id) {
        return veterinarioDAO.find(new Veterinario(id));
    }

    public void save(Veterinario vet) {
        if (vet.getId() == null) {
            Persona persona = vet.getPersona();
            personaDAO.save(persona);

            vet.setFechaRegistro(new Date());
            veterinarioDAO.save(vet);
        } else {

            Persona persona = vet.getPersona();
            personaDAO.update(persona);

        }
    }

    public void delete(Long id) {
        veterinarioDAO.delete(new Veterinario(id));
    }

}
