package com.richardhell.petclinic.controller.admin;

import com.richardhell.petclinic.model.Persona;
import com.richardhell.petclinic.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
@RequestMapping("adm/personal")
public class PersonalController {

    @Autowired
    PersonalService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("usuarios", service.allUsuario());
        return "admin/personal/personal";
    }

    @RequestMapping("new")
    public String create(Model model) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("persona", new Persona());
        return "admin/personal/personalForm";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {

        Usuario usuario = service.findUsuario(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("persona", usuario.getPersona());
        return "admin/personal/personalForm";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute("usuario") Usuario user) {

        service.save(user);
        return "redirect:/adm/personal";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Long id) {

        service.deleteUsuario(id);
        return "redirect:/adm/personal";
    }

}
