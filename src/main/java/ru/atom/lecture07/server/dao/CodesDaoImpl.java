package ru.atom.lecture07.server.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.atom.lecture07.server.dao.CodesDao;
import ru.atom.lecture07.server.model.Codes;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Transactional
@Repository
public class CodesDaoImpl implements CodesDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Codes codes) {
        em.persist(codes);
    }

    @Override
    public Codes getbycode(Integer code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Codes> criteria = builder.createQuery(Codes.class);
        Root<Codes> from = criteria.from(Codes.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("code"), code));
        TypedQuery<Codes> typed = em.createQuery(criteria);
        Codes codes;
        try {
            codes = typed.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return codes;
    }
}
