package org.example;

import org.example.model.Toy;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ToyTest {

    @Test
    public void testToLeftFromNorth() {
        Toy toy = new Toy();
        toy.setDirection("NORTH");
        toy.toLeft();
        assertEquals("WEST", toy.getDirection());
    }

    @Test
    public void testToLeftFromWEST() {
        Toy toy = new Toy();
        toy.setDirection("WEST");
        toy.toLeft();
        assertEquals("SOUTH", toy.getDirection());
    }

    @Test
    public void testToLeftFromSOUTH() {
        Toy toy = new Toy();
        toy.setDirection("SOUTH");
        toy.toLeft();
        assertEquals("EAST", toy.getDirection());
    }

    @Test
    public void testToLeftFromEAST() {
        Toy toy = new Toy();
        toy.setDirection("EAST");
        toy.toLeft();
        assertEquals("NORTH", toy.getDirection());
    }

    @Test
    public void testToRightFromNorth() {
        Toy toy = new Toy();
        toy.setDirection("NORTH");
        toy.toRight();
        assertEquals("EAST", toy.getDirection());
    }

    @Test
    public void testToRightFromEast() {
        Toy toy = new Toy();
        toy.setDirection("EAST");
        toy.toRight();
        assertEquals("SOUTH", toy.getDirection());
    }

    @Test
    public void testToRightFromSouth() {
        Toy toy = new Toy();
        toy.setDirection("SOUTH");
        toy.toRight();
        assertEquals("WEST", toy.getDirection());
    }

    @Test
    public void testToRightFromWest() {
        Toy toy = new Toy();
        toy.setDirection("WEST");
        toy.toRight();
        assertEquals("NORTH", toy.getDirection());
    }

    @Test
    public void testMoveToNorth() {
        Toy toy = new Toy();
        toy.place(2,2,"NORTH");
        toy.move();
        assertEquals(2, toy.getX());
        assertEquals(3, toy.getY());
    }

    @Test
    public void testMoveToNorth_preventFalling() {
        Toy toy = new Toy();
        toy.place(1,5,"NORTH");
        toy.move();
        assertEquals(1, toy.getX());
        assertEquals(5, toy.getY());

    }

    @Test
    public void testMoveToSouth() {
        Toy toy = new Toy();
        toy.place(2,2,"SOUTH");
        toy.move();
        assertEquals(2, toy.getX());
        assertEquals(1, toy.getY());
    }

    @Test
    public void testMoveToSouth_preventFalling() {
        Toy toy = new Toy();
        toy.place(1,0,"SOUTH");
        toy.move();
        assertEquals(1, toy.getX());
        assertEquals(0, toy.getY());
    }

    @Test
    public void testMoveToEast() {
        Toy toy = new Toy();
        toy.place(2,2,"EAST");
        toy.move();
        assertEquals(3, toy.getX());
        assertEquals(2, toy.getY());
    }

    @Test
    public void testMoveToEast_preventFalling() {
        Toy toy = new Toy();
        toy.place(5,2,"EAST");
        toy.move();
        assertEquals(5, toy.getX());
        assertEquals(2, toy.getY());
    }

    @Test
    public void testMoveToWest() {
        Toy toy = new Toy();
        toy.place(2,2,"WEST");
        toy.move();
        assertEquals(1, toy.getX());
        assertEquals(2, toy.getY());
    }

    @Test
    public void testMoveToWest_preventFalling() {
        Toy toy = new Toy();
        toy.place(0,2,"WEST");
        toy.move();
        assertEquals(0, toy.getX());
        assertEquals(2, toy.getY());
    }

    @Test
    public void testIsPlacedFalse() {
        Toy toy = new Toy();
        assertFalse(toy.getIsPlaced());
    }

    @Test
    public void testIsPlacedFalse_DirectionEmpty() {
        Toy toy = new Toy();
        toy.place(0,0,"");
        assertFalse(toy.getIsPlaced());
    }

    @Test
    public void testIsPlacedTrue() {
        Toy toy = new Toy();
        toy.place(0,0,"NORTH");
        assertTrue(toy.getIsPlaced());
    }

    @Test
    public void testReport() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Toy toy = new Toy();
        toy.place(2,2,"NORTH");
        toy.report();
        assertEquals("Output: 2,2,NORTH\n", outputStreamCaptor.toString());
    }
}
