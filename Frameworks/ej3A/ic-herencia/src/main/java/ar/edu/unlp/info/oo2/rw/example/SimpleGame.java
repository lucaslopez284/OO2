package ar.edu.unlp.info.oo2.rw.example;

import ar.edu.unlp.info.oo2.rw.model.GameBoard;
import ar.edu.unlp.info.oo2.rw.model.NuclearCaterpillarRobotWithBombs;
import ar.edu.unlp.info.oo2.rw.model.NuclearOvercraftRobotWithLasers;
import ar.edu.unlp.info.oo2.rw.model.SolarCaterpillarRobotWithBombs;
import ar.edu.unlp.info.oo2.rw.model.SolarOvercraftRobotWithLasers;

public class SimpleGame {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        board.add(new NuclearCaterpillarRobotWithBombs("Twonky"));
        board.add(new NuclearOvercraftRobotWithLasers("Hammer Bot"));
        board.runForCicles(5);
        
        GameBoard board2 = new GameBoard();
        board2.add(new SolarCaterpillarRobotWithBombs("Twonky"));
        board2.add(new SolarOvercraftRobotWithLasers("Hammer Bot"));
        board2.runForCicles(5);
    }
}
