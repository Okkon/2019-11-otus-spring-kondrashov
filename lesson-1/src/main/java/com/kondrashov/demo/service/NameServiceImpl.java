package com.kondrashov.demo.service;

import java.util.Scanner;

public class NameServiceImpl implements NameService {

    private String firstName;
    private String lastName;
    private Scanner in = new Scanner(System.in);

    @Override
    public void askForFirstName() {

        System.out.println("Введите имя");
        this.firstName = in.next();

    }

    @Override
    public void askForLastName() {

        System.out.println("Введите фамилию");
        this.lastName = in.next();
    }

    @Override
    public String  getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
