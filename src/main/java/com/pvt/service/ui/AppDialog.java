package com.pvt.service.ui;

import com.pvt.service.person.PersonService;

public class AppDialog {
    private static final String START_MSG =
            "1 - add personService\n" +
                    "2 - find personService by ID\n" +
                    "3 - delete personService by ID\n" +
                    "4 - delete personService by name\n" +
                    "5 - help\n" +
                    "6 - exit\n";
    private static final String DONE = "Done!";
    private static final String ID = "ID: ";
    private static final String FIRST_NAME = "First name: ";
    private static final String LAST_NAME = "Last name: ";
    private static final String AGE = "Age: ";
    private PersonService personService;
    private InputData inputData;


    public AppDialog() {
        sayHi();
        inputData = new InputData();
        personService = new PersonService();
    }

    public void sayHi() {
        System.out.println(START_MSG);
    }

    public void dialog() {
        do {
            switch (inputData.scanInt()) {
                case 1:
                    System.out.println(FIRST_NAME);
                    String personFirstName = inputData.scanString();
                    System.out.println(LAST_NAME);
                    String personLastName = inputData.scanString();
                    System.out.println(AGE);
                    int age = inputData.scanInt();
                    personService.save(personFirstName, personLastName, age);
                    System.out.println(DONE);
                    break;

                case 2:
                    System.out.println(ID);
                    int findId = inputData.scanInt();
                    personService.getPersonByIdByGet(findId);
                    System.out.println(personService.toString());
                    break;

                case 3:
                    System.out.println(ID);
                    int delId = inputData.scanInt();
                    personService.deletePersonById(delId);
                    System.out.println(DONE);
                    break;

                case 4:
                    System.out.println(FIRST_NAME);
                    String delFirstName = inputData.scanString();
                    personService.deletePersonByFirstName(delFirstName);
                    System.out.println(DONE);
                    break;
                case 5:
                    System.out.println(START_MSG);
                    break;
                case 6:
                    System.exit(0);
            }
        } while (inputData.repeat());
    }

}
