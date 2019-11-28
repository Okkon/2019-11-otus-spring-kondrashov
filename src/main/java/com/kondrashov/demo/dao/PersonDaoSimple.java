package com.kondrashov.demo.dao;

import com.kondrashov.demo.domain.Person;

public class PersonDaoSimple implements PersonDao {

    private Integer defaultAge;

    public PersonDaoSimple(){

    }

    public Integer getDefaultAge() {
        return defaultAge;
    }

    public void setDefaultAge(Integer defaultAge) {
        this.defaultAge = defaultAge;
    }

    public Person findByName(String name) {
        return new Person();
    }
}
