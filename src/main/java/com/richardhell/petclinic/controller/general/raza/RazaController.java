package com.richardhell.petclinic.controller.general.raza;

import com.richardhell.petclinic.model.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("gen/raza")
public class RazaController {

    @Autowired
    RazaService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("razas", service.all());
        model.addAttribute("especies", service.allEspecie());
        model.addAttribute("raza", new Raza());
        return "general/raza";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {

        model.addAttribute("razas", service.all());
        model.addAttribute("especies", service.allEspecie());
        model.addAttribute("raza", service.find(id));
        return "general/raza";

    }

    @RequestMapping("save")
    public String save(Raza raza) {

        service.save(raza);
        return "redirect:/gen/raza";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);
        return "redirect:/gen/raza";
    }

    @ExceptionHandler(Exception.class)
    public String handleConflict() {
        return "redirect:/gen/raza";
    }

}
