import javax.imageio.stream.IIOByteBuffer;

/**
 * Created by yosuk on 2/10/2017.
 */
public class RealHuman extends Player {

    /**
     * Constructor will set playerName to "Player", and assign null for initial result
     */
    public RealHuman() {
        playerResult = null;
        setPlayerName("Player");
        numWins = 0;
        numLosses = 0;
    }

    /**
     * This constructor will set the player name
     * @param playerName
     */
    public RealHuman(String playerName) {
        this();
        setPlayerName(playerName);
    }

    /**
     * This method asks the user for his input for Roshambo
     * @return Roshambo enum for user choice
     */
    private Roshambo getUserChoice() {
        // Prompt player on their choice
        System.out.print("Rock, paper, or scissors? (R/P/S) ");

        // Return appropriate value, user can input lower or upper case
        switch (InputValidator.getValidString(new String[] {"R","P","S"}).toUpperCase().charAt(0)) {
            case 'R':
                return Player.Roshambo.ROCK;
            case 'P':
                return Player.Roshambo.PAPER;
            case 'S':
                return Player.Roshambo.SCISSORS;
            default:
                return null;
        }
    }

    /**
     * This method will set playerResult to whatever the user chooses
     * @return
     */
    @Override
    public Roshambo generateRoshambo() {
        playerResult = getUserChoice();

        return playerResult;
    }
}
