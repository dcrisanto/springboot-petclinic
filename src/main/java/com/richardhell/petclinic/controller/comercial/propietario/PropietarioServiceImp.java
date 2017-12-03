package com.richardhell.petclinic.controller.comercial.propietario;

import com.richardhell.petclinic.dao.PersonaDAO;
import com.richardhell.petclinic.dao.PropietarioDAO;
import com.richardhell.petclinic.model.Persona;
import com.richardhell.petclinic.model.Propietario;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PropietarioServiceImp implements PropietarioService {

    @Autowired
    PropietarioDAO propietarioDAO;

    @Autowired
    PersonaDAO personaDAO;

    @Override
    public List<Propietario> all() {
        return propietarioDAO.all();
    }

    @Override
    public Propietario find(Long id) {
        return propietarioDAO.find(new Propietario(id));
    }

    @Override
    public void save(Propietario prop) {

        if (prop.getId() == null) {
            Persona persona = prop.getPersona();
            personaDAO.save(persona);

            prop.setFechaRegistro(new Date());
            propietarioDAO.save(prop);
        } else {

            Persona persona = prop.getPersona();
            personaDAO.update(persona);

        }
    }

    @Override
    public void delete(Long id) {
        propietarioDAO.delete(new Propietario(id));
    }

}
