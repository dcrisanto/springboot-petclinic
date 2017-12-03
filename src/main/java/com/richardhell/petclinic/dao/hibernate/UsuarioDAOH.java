package com.richardhell.petclinic.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.richardhell.petclinic.dao.UsuarioDAO;
import com.richardhell.petclinic.helper.BaseHibernateDAO;
import com.richardhell.petclinic.helper.EstadoEnum;
import com.richardhell.petclinic.model.Usuario;
import org.hibernate.Query;

@Repository
public class UsuarioDAOH extends BaseHibernateDAO implements UsuarioDAO {

    @Override
    public Usuario find(Usuario t) {
        Criteria criteria = this.getSession().createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Usuario) criteria.uniqueResult();
    }

    @Override
    public List<Usuario> all() {
        Criteria criteria = this.getSession().createCriteria(Usuario.class);
        return criteria.list();
    }

    @Override
    public void save(Usuario t) {
        this.getSession().save(t);
    }

    @Override
    public void update(Usuario t) {
        this.getSession().merge(t);
    }

    @Override
    public void delete(Usuario t) {
        this.getSession().delete(t);
    }

    @Override
    public Usuario findByLogin(String usuario) {

        String sql = "from " + Usuario.class.getName() + " u "
                + " left join fetch u.persona p "
                + " where u.email like :EMAIL "
                + " and u.estado like :ESTADO ";

        Query query = this.getSession().createQuery(sql);
        query.setString("EMAIL", usuario);
        query.setString("ESTADO", EstadoEnum.ACT.name());

        return (Usuario) query.uniqueResult();
    }

}
