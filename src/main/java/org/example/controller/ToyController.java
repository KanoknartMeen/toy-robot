package org.example.controller;

import org.example.model.Toy;

import java.util.Objects;

import static org.example.util.constants.*;

public class ToyController {
    private final Toy toy = new Toy();

    public void processCommand(String command) {
        command = !Objects.equals(command, "") ? command.trim().toUpperCase() : "";

        if (command.startsWith("PLACE")) {
            if (command.matches(PLACE_PATTERN)){
                String placeValue = command.split(WHITE_SPACE)[1];
                String[] details = placeValue.split(PLACE_SPLIT);
                toy.place(Integer.parseInt(details[0]), Integer.parseInt(details[1]), details[2]);
            } else {
                System.out.println(INVALID_COMMAND);
            }
        } else {
            if (toy.getIsPlaced()) {
                switch (command) {
                    case "MOVE": toy.move();   break;
                    case "LEFT": toy.toLeft(); break;
                    case "RIGHT": toy.toRight(); break;
                    case "REPORT": toy.report(); break;
                    default:
                        System.out.println(INVALID_COMMAND);
                        break;
                }
            } else {
                System.out.println(INVALID_COMMAND);
            }
        }
    }
}
