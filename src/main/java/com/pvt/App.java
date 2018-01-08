package com.pvt;

import com.pvt.service.ui.AppDialog;

public class App {
    // для теста
//    public static void main(String[] args) {
//
//        PersonService personService = new PersonService();
//
///*
//  Method adds entity of person to DB by using automatic setting of the Id,
//  need to set generator as increment, identity or native
// */
//        System.out.println("-----Begin add persons WITHOUT id----");
//        personService.save("Tommy", "Salo", 44);
//        personService.save("Tim", "Cook", 44);
//        System.out.println("---------------Done--------------");
//
///*
// Method adds entity of person to DB by using manual entry of the Id
// need to set generator as assigned
//*/
//        System.out.println("-----Begin add person WITH id----");
//        personService.save(15, "Jeremy", "Hook", 23);
//        System.out.println("---------------Done--------------");
//
//        System.out.println("-----Begin add person WITH id ----");
//        personService.save(16, "Ivan", "Ivanov", 27);
//        System.out.println("---------------Done--------------");
//
//
//
//        Person person = personService.getPersonByIdByGet(15);
//        Person person1 = personService.getPersonByIdByGet(300);
//        Person person2 = personService.getPersonByLoad(15);
//        Person person3 = personService.getPersonByLoad(200);
//        System.out.println(person);
//        System.out.println(person1);
//        System.out.println(person2);
//        try {
//            System.out.println(person3);
//        } catch (ObjectNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        System.out.println("--Save and delete Person--");
//        personService.saveDeletePerson("Ivan", "Ivanov", 27);
//        System.out.println("-----done");
//
//        System.out.println("---delete Person by ID---");
//        personService.deletePersonById(15);
//        System.out.println("-----done");
//
//        System.out.println("--Delete all Person with such name as--");
//        personService.deletePersonByFirstName("Tim");
//        System.out.println("-----done");
//
//    }


    //Main class for jar application
    public static void main(String[] args) {
        AppDialog appDialog = new AppDialog();
        appDialog.dialog();
    }
}
