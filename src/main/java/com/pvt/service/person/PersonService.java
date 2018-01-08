package com.pvt.service.person;

import com.pvt.DAO.PersonDAO;
import com.pvt.DAO.impl.PersonDaoImpl;
import com.pvt.POJOs.Person;

public class PersonService {

    private PersonDAO personDAO = new PersonDaoImpl();

    public void save(String firstName, String lastName, Integer age) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        personDAO.save(person);
    }

    public void save(Integer id, String firstName, String lastName, Integer age) {
        Person person = new Person();
        person.setPersonId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        personDAO.save(person);
    }

    public Person getPersonByIdByGet(Integer personId) {
        return personDAO.getPersonByIdByGet(personId);
    }

    public Person getPersonByIdByLoad(Integer personId) {
        return personDAO.getPersonByIdByLoad(personId);
    }

    public Person getPersonByLoad(Integer id) {
        return personDAO.getPersonByIdByLoad(id);
    }

    public Person getPersonByIdFirstName(String firstName) {
        return personDAO.getPersonByFirstName(firstName);
    }

    public void deletePersonById(Integer id) {
        Person person = personDAO.getPersonByIdByGet(id);
        if (person != null) {
            personDAO.delete(person);
        } else {
            System.out.println("Person with id=" + id + " doesn't exist");
        }
    }

    public void deletePersonByFirstName(String firstName) {
        Person person = personDAO.getPersonByFirstName(firstName);
        if (person != null) {
            personDAO.delete(person);
        } else {
            System.out.println("Person with first name = \"" + firstName + "\" doesn't exist");
        }
    }

    public void saveDeletePerson(String firsName, String lastName, Integer age) {
        Person person = new Person(firsName, lastName, age);
        personDAO.save(person);
        personDAO.delete(person);
    }
}
