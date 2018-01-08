package com.pvt.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactoryAutoId;
    private static SessionFactory sessionFactoryManualId;

    private static SessionFactory buildSessionFactoryForAutoId() {
        try {
            // Create the SessionFactory from hibernate_auto_id.cfg.xml
            return new Configuration().configure("hibernate_auto_id.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionFactoryForManualId() {
        try {
            // Create the SessionFactory from hibernate_manual_id.cfg.xml
            return new Configuration().configure("hibernate_manual_id.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactoryForAutoId() {
        if (sessionFactoryAutoId == null) {
            sessionFactoryAutoId = HibernateUtil.buildSessionFactoryForAutoId();
            return sessionFactoryAutoId;
        } else {
            return sessionFactoryAutoId;
        }
    }

    public static SessionFactory getSessionFactoryForManualId() {
        if (sessionFactoryManualId == null) {
            sessionFactoryManualId = HibernateUtil.buildSessionFactoryForManualId();
            return sessionFactoryManualId;
        } else {
            return sessionFactoryManualId;
        }
    }

}