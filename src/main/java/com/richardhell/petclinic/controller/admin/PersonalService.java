package com.richardhell.petclinic.controller.admin;

import com.richardhell.petclinic.model.Usuario;
import java.util.List;

public interface PersonalService {

    public List<Usuario> allUsuario();

    public Usuario findUsuario(Long id);

    public void save(Usuario user);

    public void deleteUsuario(Long id);

}
