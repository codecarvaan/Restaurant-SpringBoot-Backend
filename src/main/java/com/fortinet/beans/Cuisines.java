package com.fortinet.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "cuisines")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cuisines {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CuisineName", nullable = false)
    private String CuisineName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuisineName() {
        return CuisineName;
    }

    public void setCuisineName(String cuisineName) {
        CuisineName = cuisineName;
    }
}
