package ru.atom.lecture07.server.model;

import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "transactions", schema = "service")
public class Transactions {

    @Id
    private Integer code;

    private Date time = new Date();

    private String status;

    private Integer contractnumber;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getContractNumber() {
        return contractnumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractnumber = contractNumber;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return " Transactions{" +
                "code=" + code +
                ", status='" + status +
                ", time=" + time +
                ", contractNumber=" + contractnumber +
                '}';
    }
}
