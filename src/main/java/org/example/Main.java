package org.example;


import org.example.controller.ToyController;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ToyController toyController = new ToyController();
        System.out.println("Please input your command...");
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                toyController.processCommand(command);
            }
        } finally {
            scanner.close();
        }
    }
}

