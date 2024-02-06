package org.example;

import org.example.controller.ToyController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.example.util.constants.INVALID_COMMAND;
import static org.junit.jupiter.api.Assertions.*;


public class ToyControllerTest {
    private ToyController toyController;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        toyController = new ToyController();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void testProcessCommand_PlaceCommand() {
        toyController.processCommand("PLACE 0,0,NORTH");
        toyController.processCommand("REPORT");
        assertEquals("Output: 0,0,NORTH\n", outputStreamCaptor.toString());
    }

    @Test
    public void testProcessCommand_MoveCommand() {
        toyController.processCommand("PLACE 0,0,NORTH");
        toyController.processCommand("MOVE");
        toyController.processCommand("REPORT");
        assertEquals("Output: 0,1,NORTH\n", outputStreamCaptor.toString());
    }

    @Test
    public void testProcessCommand_LeftCommand() {
        toyController.processCommand("PLACE 0,0,NORTH");
        toyController.processCommand("LEFT");
        toyController.processCommand("REPORT");
        assertEquals("Output: 0,0,WEST\n", outputStreamCaptor.toString());
    }

    @Test
    public void testProcessCommand_RightCommand() {
        toyController.processCommand("PLACE 0,0,NORTH");
        toyController.processCommand("RIGHT");
        toyController.processCommand("REPORT");
        assertEquals("Output: 0,0,EAST\n", outputStreamCaptor.toString());
    }

    @Test
    public void testProcessCommand_ReportCommand() {
        toyController.processCommand("PLACE 0,0,NORTH");
        toyController.processCommand("REPORT");
        assertEquals("Output: 0,0,NORTH\n", outputStreamCaptor.toString());
    }

    @Test
    public void testProcessCommand_InvalidCommand() {
        System.setErr(new PrintStream(outputStreamCaptor));
        toyController.processCommand("Run run run");
        assertEquals(INVALID_COMMAND + "\n", outputStreamCaptor.toString());
    }

    @Test
    public void testProcessCommand_InvalidPlaceCommand() {
        System.setErr(new PrintStream(outputStreamCaptor));
        toyController.processCommand("PLACE a,b,c");
        assertEquals(INVALID_COMMAND + "\n", outputStreamCaptor.toString());
    }

    @Test
    public void testProcessCommand_InvalidPlaceCommandAfterPlaced() {
        System.setErr(new PrintStream(outputStreamCaptor));
        toyController.processCommand("PLACE 0,0,NORTH");
        toyController.processCommand("Run");
        assertEquals(INVALID_COMMAND + "\n", outputStreamCaptor.toString());
    }

    @Test
    public void testProcessCommand_UnplacedMoveCommand() {
        System.setErr(new PrintStream(outputStreamCaptor));
        toyController.processCommand("MOVE");
        assertEquals(INVALID_COMMAND + "\n", outputStreamCaptor.toString());
    }

    @Test
    public void testProcessCommand_EmptyCommand() {
        System.setErr(new PrintStream(outputStreamCaptor));
        toyController.processCommand("");
        assertEquals(INVALID_COMMAND + "\n", outputStreamCaptor.toString());
    }
}