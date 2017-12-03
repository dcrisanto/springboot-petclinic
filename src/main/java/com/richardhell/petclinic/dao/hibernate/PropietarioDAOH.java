package com.richardhell.petclinic.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.richardhell.petclinic.dao.PropietarioDAO;
import com.richardhell.petclinic.helper.BaseHibernateDAO;
import com.richardhell.petclinic.model.Propietario;

@Repository
public class PropietarioDAOH extends BaseHibernateDAO implements PropietarioDAO {

    @Override
    public Propietario find(Propietario t) {
        Criteria criteria = this.getSession().createCriteria(Propietario.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Propietario) criteria.uniqueResult();
    }

    @Override
    public List<Propietario> all() {
        Criteria criteria = this.getSession().createCriteria(Propietario.class);
        return criteria.list();
    }

    @Override
    public void save(Propietario t) {
        this.getSession().save(t);
    }

    @Override
    public void update(Propietario t) {
        this.getSession().merge(t);
    }

    @Override
    public void delete(Propietario t) {
        this.getSession().delete(t);
    }
}
