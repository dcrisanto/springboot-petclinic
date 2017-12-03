package com.richardhell.petclinic.controller.admin;

import com.richardhell.petclinic.dao.PersonaDAO;
import com.richardhell.petclinic.dao.UsuarioDAO;
import com.richardhell.petclinic.helper.EstadoEnum;
import com.richardhell.petclinic.model.Persona;
import com.richardhell.petclinic.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonalServiceImp implements PersonalService {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    PersonaDAO personaDAO;

    @Override
    public List<Usuario> allUsuario() {
        return usuarioDAO.all();
    }

    @Override
    public Usuario findUsuario(Long id) {
        return usuarioDAO.find(new Usuario(id));
    }

    @Override
    public void save(Usuario user) {
        if (user.getId() == null) {
            Persona persona = user.getPersona();
            personaDAO.save(persona);

            user.setEmail(persona.getEmail());
            user.setPassword(persona.getEmail());
            user.setEstado(EstadoEnum.ACT.name());
            usuarioDAO.save(user);
        } else {
            Persona persona = user.getPersona();
            personaDAO.update(persona);

            user.setEmail(persona.getEmail());
            usuarioDAO.update(user);
        }
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioDAO.delete(new Usuario(id));
    }

}
