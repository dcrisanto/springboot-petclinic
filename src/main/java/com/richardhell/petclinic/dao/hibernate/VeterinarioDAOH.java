package com.richardhell.petclinic.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.richardhell.petclinic.dao.VeterinarioDAO;
import com.richardhell.petclinic.helper.BaseHibernateDAO;
import com.richardhell.petclinic.model.Veterinario;

@Repository
public class VeterinarioDAOH extends BaseHibernateDAO implements VeterinarioDAO{



    @Override
    public Veterinario find(Veterinario t){
        Criteria criteria = this.getSession().createCriteria(Veterinario.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Veterinario) criteria.uniqueResult();
    }

    @Override
    public List<Veterinario> all(){
        Criteria criteria = this.getSession().createCriteria(Veterinario.class);
        return criteria.list();
    }

    @Override
    public void save(Veterinario t){
        this.getSession().save(t);
    }

    @Override
    public void update(Veterinario t){
        this.getSession().merge(t);
    }

    @Override
    public void delete(Veterinario t){
        this.getSession().delete(t);
    }
}