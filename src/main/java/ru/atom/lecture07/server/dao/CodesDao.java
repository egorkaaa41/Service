package ru.atom.lecture07.server.dao;

import ru.atom.lecture07.server.model.Codes;

public interface CodesDao {

    void save(Codes codes);

    Codes getbycode(Integer code);

}
