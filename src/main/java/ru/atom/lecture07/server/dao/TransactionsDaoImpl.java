package ru.atom.lecture07.server.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.atom.lecture07.server.model.Transactions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Transactional
@Repository
public class TransactionsDaoImpl implements  TransactionsDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Transactions> findAllStatus() {
        return em.createQuery("Select t from " + Transactions.class.getSimpleName() + " t").getResultList();
    }

    @Override
    public void save(Transactions transactions) {
        em.persist(transactions);
    }

    @Override
    public void update(Transactions transactions) {
        em.merge(transactions);
    }
}
