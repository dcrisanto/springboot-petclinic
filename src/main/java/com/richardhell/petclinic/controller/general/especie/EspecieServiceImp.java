package com.richardhell.petclinic.controller.general.especie;

import com.richardhell.petclinic.dao.EspecieDAO;
import com.richardhell.petclinic.model.Especie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EspecieServiceImp implements EspecieService {

    @Autowired
    EspecieDAO especieDAO;

    public List<Especie> all() {
        return especieDAO.all();
    }

    public Especie find(Long id) {
        return especieDAO.find(new Especie(id));
    }

    public void save(Especie especie) {
        if (especie.getId() == null) {
            especieDAO.save(especie);
        } else {
            especieDAO.update(especie);
        }
    }

    public void delete(Long id) {
        especieDAO.delete(new Especie(id));
    }

}
