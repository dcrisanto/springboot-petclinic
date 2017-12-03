package com.richardhell.petclinic.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.richardhell.petclinic.dao.RazaDAO;
import com.richardhell.petclinic.helper.BaseHibernateDAO;
import com.richardhell.petclinic.model.Raza;

@Repository
public class RazaDAOH extends BaseHibernateDAO implements RazaDAO {

    @Override
    public Raza find(Raza t) {
        Criteria criteria = this.getSession().createCriteria(Raza.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Raza) criteria.uniqueResult();
    }

    @Override
    public List<Raza> all() {
        Criteria criteria = this.getSession().createCriteria(Raza.class);
        return criteria.list();
    }

    @Override
    public void save(Raza t) {
        this.getSession().save(t);
    }

    @Override
    public void update(Raza t) {
        this.getSession().merge(t);
    }

    @Override
    public void delete(Raza t) {
        this.getSession().delete(t);
    }
}
