package ru.atom.lecture07.server.dao;


import ru.atom.lecture07.server.model.Transactions;

import java.util.List;

public interface TransactionsDao {

    List<Transactions> findAllStatus();

    void save(Transactions tran);

    void update(Transactions tran);
}
