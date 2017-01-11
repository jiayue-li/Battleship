import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jiayueli on 1/10/17.
 *
 * Sets up and simulates the game of battleship.
 *
 */
public class Game {

    private GameHelper helper = new GameHelper();
    private ArrayList <Ship> battleShipsList = new ArrayList<Ship>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        Ship a = new Ship();
        Ship b = new Ship();
        Ship c = new Ship();
        a.name = "Pinta";
        b.name = "Nina";
        c.name = "Santa Maria";
        battleShipsList.add(a);
        battleShipsList.add(b);
        battleShipsList.add(c);

        for (Ship dc: battleShipsList) {
            ArrayList <String> loc = helper.placeDotCom(3);
            dc.setLocationCells(loc);
        }
        System.out.println("7x7 Battleship commencing... \nEnter coordinates, lowercase letter + number.");
    }


    private String checkUserGuess(String guess ) {
        String result = "miss";

        for (Ship dc : battleShipsList) {
            numOfGuesses += 1;
            result = dc.checkYourself(guess);
            if (result.contains("kill")) {
                battleShipsList.remove(dc);
                break;
            }
            if (result.contains("hit")) {
                break;
            }
        }
        return result;
    }

    private void startPlaying() {

        while (!battleShipsList.isEmpty()) {
            System.out.println("\nWhat's your play?");
            Scanner kb = new Scanner(System.in);
            System.out.println(checkUserGuess(kb.next()));
        }
        finishGame();
    }

    private void finishGame() {
        System.out.println("GAME OVER!! YOU DEFEATED THE BATTLESHIPS!!!");
        if (numOfGuesses < 25) {
            System.out.println("You sank the ships in " + numOfGuesses + " tries!! Pretty Good!");

        }
        else {
            System.out.println("You sank the ships in " + numOfGuesses + " tries!! Wow, you really suck.");
        }
    }

    public static void main (String [] args) {
        Game g = new Game();
        g.setUpGame();
        g.startPlaying();


    }

}


