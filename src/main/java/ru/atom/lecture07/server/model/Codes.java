package ru.atom.lecture07.server.model;

import javax.persistence.*;

@Entity
@Table(name = "codes", schema = "service")
public class Codes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "code",unique = true)
    private Integer code;

    public Integer getId() {
        return id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Codes{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
