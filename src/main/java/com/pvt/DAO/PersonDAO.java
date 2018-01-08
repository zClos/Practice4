package com.pvt.DAO;

import com.pvt.POJOs.Person;

public interface PersonDAO {

    void save(Person person);

    Person getPersonByIdByGet(Integer personId);

    Person getPersonByIdByLoad(Integer personId);

    Person getPersonByFirstName(String name);

    void delete(Person person);

}
