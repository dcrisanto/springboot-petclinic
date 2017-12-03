package com.richardhell.petclinic.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.richardhell.petclinic.dao.VisitaDAO;
import com.richardhell.petclinic.helper.BaseHibernateDAO;
import com.richardhell.petclinic.model.Visita;

@Repository
public class VisitaDAOH extends BaseHibernateDAO implements VisitaDAO {

  

    @Override
    public Visita find(Visita t) {
        Criteria criteria = this.getSession().createCriteria(Visita.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Visita) criteria.uniqueResult();
    }

    @Override
    public List<Visita> all() {
        Criteria criteria = this.getSession().createCriteria(Visita.class);
        return criteria.list();
    }

    @Override
    public void save(Visita t) {
        this.getSession().save(t);
    }

    @Override
    public void update(Visita t) {
        this.getSession().merge(t);
    }

    @Override
    public void delete(Visita t) {
        this.getSession().delete(t);
    }

    @Override
    public List<Visita> allFinalizada() {
        Criteria criteria = this.getSession().createCriteria(Visita.class);
        criteria.add(Restrictions.isNotNull("fechaSalida"));
        return criteria.list();
    }

}
