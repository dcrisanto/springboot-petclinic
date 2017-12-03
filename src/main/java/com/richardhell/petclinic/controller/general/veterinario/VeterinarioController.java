package com.richardhell.petclinic.controller.general.veterinario;

import com.richardhell.petclinic.model.Persona;
import com.richardhell.petclinic.model.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("gen/veterinario")
public class VeterinarioController {

    @Autowired
    VeterinarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("veterinarios", service.all());
        return "general/persona/veterinario";
    }

    @RequestMapping("new")
    public String create(Model model) {

        model.addAttribute("veterinario", new Veterinario());
        model.addAttribute("persona", new Persona());
        return "general/persona/veterinarioForm";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {

        Veterinario vet = service.find(id);
        model.addAttribute("veterinario", vet);
        model.addAttribute("persona", vet.getPersona());
        return "general/persona/veterinarioForm";
    }

    @RequestMapping("save")
    public String save(Veterinario vet) {

        service.save(vet);
        return "redirect:/gen/veterinario";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);
        return "redirect:/gen/veterinario";
    }

}
