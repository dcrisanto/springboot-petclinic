package com.richardhell.petclinic.controller.general.raza;

import com.richardhell.petclinic.dao.EspecieDAO;
import com.richardhell.petclinic.dao.RazaDAO;
import com.richardhell.petclinic.model.Especie;
import com.richardhell.petclinic.model.Raza;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RazaServiceImp implements RazaService {

    @Autowired
    RazaDAO razaDAO;

    @Autowired
    EspecieDAO especieDAO;

    public List<Raza> all() {
        return razaDAO.all();
    }

    @Override
    public List<Especie> allEspecie() {
        return especieDAO.all();
    }

    public Raza find(Long id) {
        return razaDAO.find(new Raza(id));
    }

    public void save(Raza raza) {
        if (raza.getId() == null) {
            razaDAO.save(raza);
        } else {
            razaDAO.update(raza);
        }
    }

    public void delete(Long id) {
        razaDAO.delete(new Raza(id));
    }

}
