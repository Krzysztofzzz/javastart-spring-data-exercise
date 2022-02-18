package com.javastart.spring.controllers;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ApplicationController {
    private int option = 0;
    Scanner scanner = new Scanner(System.in);


    public void run() {
        do {
            printOptions();
            option = scanner.nextInt();
        } while (option != 8);


    }

    private void printOptions() {
        System.out.println("Opcje:");
        System.out.println("1 - Dodaj urządzenie");

        System.out.println("8 - Koniec");

        System.out.println("Podaj Id opcji:");
    }
}
