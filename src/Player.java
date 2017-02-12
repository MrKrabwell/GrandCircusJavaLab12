/**
 * This is the Player class that is required by Grand Circus Java (Jan2017) Lab Number 12
 * Created by yosuk on 2/10/2017.
 */
public abstract class Player {
    // Data members
    private String playerName;                              // Holds the player's name
    public static enum Roshambo {ROCK, PAPER, SCISSORS}     // Enum that holds the Roshambo values
    Roshambo playerResult;                                  // Holds the current Roshambo result
    int numWins;                                            // Holds the number of losses
    int numLosses;                                          // Holds the number of losses

    // Getters and Setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Roshambo getPlayerResult() {
        return playerResult;
    }

    public int getNumWins() { return numWins; }

    public int getNumLosses() { return numLosses; }

    /**
     * Abstract method to generate a result for Roshambo
     * @return enum for Rock, Paper, Scissors
     */
    public abstract Roshambo generateRoshambo();

    /**
     * This method updates the win statistic
     */
    public void win() {
        ++numWins;
    }

    /**
     * This method updates the loss statistic
     */
    public void lose() {
        ++numLosses;
    }


    /**
     * This method clears the player stats
     */
    public void clearStats() {
        numWins = 0;
        numLosses = 0;
    }


    /**
     * This method will convert the current playerResult to a string
     * @return
     */
    public String toString() {

        // Depending on current playerResult, return a string that is the player's result
        switch (playerResult) {
            case ROCK:
                return "Rock";
            case PAPER:
                return "Paper";
            case SCISSORS:
                return "Scissors";
            default:
                return "";
        }
    }


}
