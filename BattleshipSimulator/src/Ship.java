/**
 * Created by jiayueli on 1/10/17.
 *
 * Class for a battleship.
 *
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Ship {

    ArrayList<String> locationCells = new ArrayList<String>();
    String name;
    String result = "miss";


    String checkYourself(String guess)
    {
        //takes in user input and returns hit, miss, or kill

        if (locationCells.contains(guess)) {
            if (locationCells.size() == 1) {
                result = "You killed " + name + "!";
            }
            else {
                result = "You hit " + name + "!";
            }
            locationCells.remove(locationCells.indexOf(guess));
        }
        else {
            result = "You missed!";
        }
        return result;
    }

    void setLocationCells(ArrayList<String> locCells) {
        locationCells = locCells;
    }


}