package com.richardhell.petclinic.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.richardhell.petclinic.dao.PersonaDAO;
import com.richardhell.petclinic.helper.BaseHibernateDAO;
import com.richardhell.petclinic.model.Persona;

@Repository
public class PersonaDAOH extends BaseHibernateDAO implements PersonaDAO {

    @Override
    public Persona find(Persona t) {
        Criteria criteria = this.getSession().createCriteria(Persona.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Persona) criteria.uniqueResult();
    }

    @Override
    public List<Persona> all() {
        Criteria criteria = this.getSession().createCriteria(Persona.class);
        return criteria.list();
    }

    @Override
    public void save(Persona t) {
        this.getSession().save(t);
    }

    @Override
    public void update(Persona t) {
        this.getSession().merge(t);
    }

    @Override
    public void delete(Persona t) {
        this.getSession().delete(t);
    }
}
