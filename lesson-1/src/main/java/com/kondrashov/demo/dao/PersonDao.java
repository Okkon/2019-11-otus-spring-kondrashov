package com.kondrashov.demo.dao;

import com.kondrashov.demo.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}
