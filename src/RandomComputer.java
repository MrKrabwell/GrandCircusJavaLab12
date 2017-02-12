/**
 * This is the Random Computer class that extends the Player class.
 * This class generates random outputs for Roshambo
 * Created by yosuk on 2/10/2017.
 */
import java.util.Random;

public class RandomComputer extends Player {

    // Data members
    private Random rand = new Random();

    /**
     * Constructor will set playerName to computer, and assign null for initial result
     */
    public RandomComputer() {
        playerResult = null;
        setPlayerName("Computer");
        numWins = 0;
        numLosses = 0;
    }

    /**
     * This constructor will "override" the "Computer" player name
     * @param playerName
     */
    public RandomComputer(String playerName) {
        this();
        setPlayerName(playerName);
    }

    /**
     * This method randomly generates a result of Roshambo
     * @return player's enum values of Roshambo
     */
    @Override
    public Roshambo generateRoshambo() {
        // Randomly choose an enum and assign to playerResult
        playerResult = Roshambo.values()[rand.nextInt(3)];

        // Return the result
        return playerResult;
    }
}
