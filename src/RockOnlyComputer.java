/**
 * This is the class that extends the Player class.
 * This computer player only generates rock as a result.
 * Created by yosuk on 2/10/2017.
 */
public class RockOnlyComputer extends Player {

    /**
     * Constructor will set playerName to computer, and assinn null for initial result
     */
    public RockOnlyComputer() {
        playerResult = null;
        setPlayerName("Rock Man");
        numWins = 0;
        numLosses = 0;
    }

    /**
     * This constructor will set the player name as well
     * @param playerName
     */
    public RockOnlyComputer(String playerName) {
        this();
        setPlayerName(playerName);
    }

    /**
     * This method generates Roshambo for this player, but always return rock
     * @return Roshambo enum Rock
     */
    @Override
    public Roshambo generateRoshambo() {
        playerResult = Roshambo.ROCK;
        return playerResult;
    }
}
