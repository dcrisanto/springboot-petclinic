package com.richardhell.petclinic.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.richardhell.petclinic.dao.EspecieDAO;
import com.richardhell.petclinic.helper.BaseHibernateDAO;
import com.richardhell.petclinic.model.Especie;

@Repository
public class EspecieDAOH extends BaseHibernateDAO implements EspecieDAO {

    @Override
    public Especie find(Especie t) {
        Criteria criteria = this.getSession().createCriteria(Especie.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Especie) criteria.uniqueResult();
    }

    @Override
    public List<Especie> all() {
        Criteria criteria = this.getSession().createCriteria(Especie.class);
        return criteria.list();
    }

    @Override
    public void save(Especie t) {
        this.getSession().save(t);
    }

    @Override
    public void update(Especie t) {
        this.getSession().merge(t);
    }

    @Override
    public void delete(Especie t) {
        this.getSession().delete(t);
    }
}
