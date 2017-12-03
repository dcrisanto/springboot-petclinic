package com.richardhell.petclinic.controller.security;

import com.richardhell.petclinic.model.Usuario;

public interface PrincipalService {

    Usuario findByLogin(String username);

}
