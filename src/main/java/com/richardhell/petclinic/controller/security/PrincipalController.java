package com.richardhell.petclinic.controller.security;

import com.richardhell.petclinic.model.Usuario;
import java.security.Principal;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrincipalController {

    @Autowired
    PrincipalService service;

    @RequestMapping("/")
    public String index() {
        return "redirect:/com/atencion";
    }

    @RequestMapping("login")
    public String login(@RequestParam(required = false, value = "error") String error, Model model) {

        if (error != null) {
            model.addAttribute("loginError", true);
        }
        return "security/login";
    }

    @RequestMapping("successLogin")
    public String successLogin(Principal principal, HttpSession session) {

        Usuario usuario = service.findByLogin(principal.getName());
        session.setAttribute("USUARIO_AUTENTICADO", usuario);

        return "redirect:/com/atencion";

    }

}
