package com.richardhell.petclinic.controller.general.especie;

import com.richardhell.petclinic.model.Especie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("gen/especie")
public class EspecieController {

    @Autowired
    EspecieService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("especies", service.all());
        model.addAttribute("especie", new Especie());
        return "general/especie";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {

        model.addAttribute("especies", service.all());
        model.addAttribute("especie", service.find(id));
        return "general/especie";
    }

    @RequestMapping("save")
    public String save(Especie especie) {

        service.save(especie);
        return "redirect:/gen/especie";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);
        return "redirect:/gen/especie";
    }

    @ExceptionHandler(Exception.class)
    public String handleConflict() {
        return "redirect:/gen/especie";
    }
}
