package com.pvt.DAO.impl;

import com.pvt.DAO.PersonDAO;
import com.pvt.POJOs.Person;
import com.pvt.util.HibernateUtil;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PersonDaoImpl implements PersonDAO {


    @Override
    public void save(Person person) {
        Session session = null;
        try {
            if (person.getPersonId() != null) {
                session = HibernateUtil.getSessionFactoryForManualId().openSession();
            } else {
                session = HibernateUtil.getSessionFactoryForAutoId().openSession();
            }
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Person getPersonByIdByGet(Integer personId) {
        Session session = null;
        Person person = null;
        try {
            session = HibernateUtil.getSessionFactoryForAutoId().openSession();
            person = (Person) session.get(Person.class, personId);
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return person;
    }

    /**
     * Method can throw Object not found exception,
     * use try catch construction at the first place of uses of the returned object
     */
    @Override
    public Person getPersonByIdByLoad(Integer personId) throws ObjectNotFoundException {
        Session session = HibernateUtil.getSessionFactoryForAutoId().openSession();
        return (Person) session.load(Person.class, personId);
    }

    @Override
    public Person getPersonByFirstName(String firstName) {
        Session session = HibernateUtil.getSessionFactoryForAutoId().openSession();
        Query query = session.createQuery("FROM Person WHERE firstName = :firstName");
        query.setParameter("firstName", firstName);
        return (Person) query.uniqueResult();
    }

    @Override
    public void delete(Person person) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactoryForAutoId().openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
