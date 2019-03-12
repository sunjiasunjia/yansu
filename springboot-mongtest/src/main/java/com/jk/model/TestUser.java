package com.jk.model;

import java.io.Serializable;

public class TestUser implements Serializable {


    private static final long serialVersionUID = 3190164131459173256L;

    private  Integer id;

    private  String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
