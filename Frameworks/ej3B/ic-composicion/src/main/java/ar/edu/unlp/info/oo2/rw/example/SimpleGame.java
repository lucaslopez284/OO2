package ar.edu.unlp.info.oo2.rw.example;

import ar.edu.unlp.info.oo2.rw.model.*;

public class SimpleGame {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        board.add(new Robot("Twonky", new Caterpillar(), new NuclearPlant(), new BombsSystem()));
        board.add(new Robot("Hammer Bot", new Overcraft(), new NuclearPlant(), new LasersSystem()));
        board.runForCicles(5);
        
        GameBoard board2 = new GameBoard();
        board2.add(new Robot("Twonky", new Motor4x4(), new NuclearPlant(), new BombsSystem()));
        board2.add(new Robot("Hammer Bot", new Motor4x4(), new NuclearPlant(), new LasersSystem()));
        board2.runForCicles(5);
    }
}
