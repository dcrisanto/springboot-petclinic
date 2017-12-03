package com.richardhell.petclinic.controller.comercial.mascota;

import com.richardhell.petclinic.dao.EspecieDAO;
import com.richardhell.petclinic.dao.MascotaDAO;
import com.richardhell.petclinic.dao.PropietarioDAO;
import com.richardhell.petclinic.dao.RazaDAO;
import com.richardhell.petclinic.model.Especie;
import com.richardhell.petclinic.model.Mascota;
import com.richardhell.petclinic.model.Propietario;
import com.richardhell.petclinic.model.Raza;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MascotaServiceImp implements MascotaService {

    @Autowired
    RazaDAO razaDAO;

    @Autowired
    EspecieDAO especieDAO;

    @Autowired
    PropietarioDAO propietarioDAO;

    @Autowired
    MascotaDAO mascotaDAO;

    @Override
    public List<Mascota> all() {
        return mascotaDAO.all();
    }

    @Override
    public Mascota find(Long id) {
        return mascotaDAO.find(new Mascota(id));
    }

    @Override
    public void save(Mascota mascota) {
        if (mascota.getId() == null) {
            mascotaDAO.save(mascota);
        } else {
            mascotaDAO.update(mascota);
        }
    }

    @Override
    public void delete(Long id) {
        mascotaDAO.delete(new Mascota(id));
    }

    @Override
    public List<Especie> allEspecie() {
        return especieDAO.all();
    }

    @Override
    public List<Raza> allRaza() {
        return razaDAO.all();
    }

    @Override
    public List<Propietario> allPropietario() {
        return propietarioDAO.all();
    }

    @Override
    public List<Mascota> allByPropietario(Propietario prop) {
        return mascotaDAO.allByPropietario(prop);
    }

    @Override
    public Propietario findPropietario(Long propietario) {
        return propietarioDAO.find(new Propietario(propietario));
    }

}
