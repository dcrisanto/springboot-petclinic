package com.richardhell.petclinic.controller.comercial.propietario;

import com.richardhell.petclinic.model.Persona;
import com.richardhell.petclinic.model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("com/propietario")
public class PropietarioController {

    @Autowired
    PropietarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("props", service.all());
        return "comercial/cliente/propietario";
    }

    @RequestMapping("new")
    public String create(Model model) {

        model.addAttribute("propietario", new Propietario());
        model.addAttribute("persona", new Persona());
        return "comercial/cliente/propietarioForm";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {

        Propietario vet = service.find(id);
        model.addAttribute("propietario", vet);
        model.addAttribute("persona", vet.getPersona());

        return "comercial/cliente/propietarioForm";
    }

    @RequestMapping("save")
    public String save(Propietario prop) {
        service.save(prop);
        return "redirect:/com/propietario";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);
        return "redirect:/com/propietario";
    }
}
