package com.richardhell.petclinic.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.richardhell.petclinic.dao.MascotaDAO;
import com.richardhell.petclinic.helper.BaseHibernateDAO;
import com.richardhell.petclinic.model.Mascota;
import com.richardhell.petclinic.model.Propietario;

@Repository
public class MascotaDAOH extends BaseHibernateDAO implements MascotaDAO {

    @Override
    public Mascota find(Mascota t) {
        Criteria criteria = this.getSession().createCriteria(Mascota.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Mascota) criteria.uniqueResult();
    }

    @Override
    public List<Mascota> all() {
        Criteria criteria = this.getSession().createCriteria(Mascota.class);
        return criteria.list();
    }

    @Override
    public void save(Mascota t) {
        this.getSession().save(t);
    }

    @Override
    public void update(Mascota t) {
        this.getSession().merge(t);
    }

    @Override
    public void delete(Mascota t) {
        this.getSession().delete(t);
    }

    @Override
    public List<Mascota> allByPropietario(Propietario propietario) {
        Criteria criteria = this.getSession().createCriteria(Mascota.class);
        criteria.add(Restrictions.eq("propietario", propietario));
        return criteria.list();
    }

}
