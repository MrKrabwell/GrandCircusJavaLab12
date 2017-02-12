import jdk.internal.util.xml.impl.Input;

import java.util.stream.Stream;



public class RoshamboApp {

    /**
     * This method selects the user options for an opponent.  Although main uses char[] for valid selection,
     * this method uses String[] because InputValidator.getValidString uses String[].  It also returns String
     * @param opponentOptions String array to keep valid selections
     * @return Returns the selection of the user
     */
    private static String getPlayerOpponent(String[] opponentOptions) {
        // Ask user who they want to play
        System.out.printf("Would you like to play Rock Man or Computer? ");
        System.out.printf("(");
        for (int i = 0; i < opponentOptions.length; ++i ) {     // This loop prints valid options
            if (i == opponentOptions.length - 1) {
                System.out.printf("%s) ", opponentOptions[i]);
            }
            else {
                System.out.printf("%s/", opponentOptions[i]);
            }
        }
        return InputValidator.getValidString(opponentOptions);    // Read user selectio
    }

    /**
     * This method prints the final results using the two Player objects
     * @param player This is the player objects
     * @param opponent This is the opponents objects
     */
    private static void printGameStatics(Player player, Player opponent) {
        // Print heading
        System.out.printf("%-15c%-7s%-7s\n", ' ', "WINS", "LOSSES");
        for (int i = 1; i <= 29; i++) {
            System.out.print("=");
        }
        System.out.println();

        // Print each player's result
        System.out.printf("%-15s%-7d%-7d\n", player.getPlayerName(), player.getNumWins(), player.getNumLosses());
        System.out.printf("%-15s%-7d%-7d\n", opponent.getPlayerName(), opponent.getNumWins(), opponent.getNumLosses());
        System.out.println();

        // Print final winner
        if (player.getNumWins() > opponent.getNumWins()) {
            System.out.printf("%s wins this series!", player.getPlayerName());
        }
        else if (player.getNumWins() < opponent.getNumWins()) {
            System.out.printf("%s wins this series!", opponent.getPlayerName());
        }
        else {
            System.out.println("The series is a draw!!!\n");
        }
        System.out.println();

        return;
    }


    private static void playRoshambo(Player player, Player opponent) {
        // Clear the stats
        player.clearStats();
        opponent.clearStats();

        // Keep playing until user doesn't want to anymore
        while (true) {
            // Get user's choice for Roshambo and generate for both players
            player.generateRoshambo();
            opponent.generateRoshambo();

            // Print the outcome
            System.out.printf("\n%s: %s\n", player.getPlayerName(), player.getPlayerResult());
            System.out.printf("%s: %s\n", opponent.getPlayerName(), opponent.getPlayerResult());

            // Print winner and update stats
            // This is supposed to simplify the code.  The idea is to use the ordinals of the enums to keep
            // the number of if statements at a minimum
            // ROCK    |     PAPER     |     SCISSORS
            //  0              1                2
            // This condition takes care of conditions where player loses
            if (player.getPlayerResult().ordinal() == opponent.getPlayerResult().ordinal() - 1 ||
                    player.getPlayerResult().ordinal() - 2 == opponent.getPlayerResult().ordinal()) {
                System.out.printf("%s wins!\n", opponent.getPlayerName());
                // Update stats
                player.lose();
                opponent.win();
            }
            // This condition takes care of conditions where player wins
            else if (opponent.getPlayerResult().ordinal() == player.getPlayerResult().ordinal() - 1 ||
                    opponent.getPlayerResult().ordinal() - 1 == player.getPlayerResult().ordinal()) {
                System.out.printf("%s wins!\n", player.getPlayerName());
                player.win();
                opponent.lose();
            }
            // Else, it is a draw
            else {
                System.out.println("Draw!");
            }

            // Ask user if they want to keep playing the same opponent
            System.out.print("\nPlay again? (y/n) ");
            if (!InputValidator.askUserYesNo()) {
                break;
            }
            System.out.println();
        }

        // Print statistics
        printGameStatics(player,opponent);
        System.out.println();;

        return;
    }


    /**
     * This is the main program
     * @param args
     */
    public static void main(String[] args) {
        // Variable declarations
        char opponentSelection;                 // Holds the selection for opponent
        char[] opponentOptions = {'r','c'};     // Holds valid options for opponent

        // Welcome message
        System.out.println("Welcome to the Grand Circus Roshambo Game!\n");

        // If user wants to play, create new RealHuman object and ask for name
        System.out.print("Would you like to play? (y/n) ");
        if (InputValidator.askUserYesNo()) {
            System.out.print("\nOk great!  What is your name? ");
            Player humanPlayer = new RealHuman(InputValidator.getString());
            System.out.printf("\nHi %s!\n", humanPlayer.getPlayerName());

            // When player decides to play, then create new opponent objects
            Player rockMan = new RockOnlyComputer();
            Player computer = new RandomComputer();

            // Keep looping until opponent doesn't want to play anymore
            while (true) {
                // Get the opponent selection
                // This mess is because InputValidator.getValidString only takes an String array as an input,
                // and returns an array.  charAt(0) for converting string to char.
                opponentSelection = getPlayerOpponent(new String(opponentOptions).split(""))
                        .toLowerCase().charAt(0);
                System.out.println();

                // Play the game according to player options
                switch (opponentSelection) {
                    case 'r':
                        playRoshambo(humanPlayer,rockMan);
                        break;
                    case 'c':
                        playRoshambo(humanPlayer,computer);
                        break;
                    default:
                        break;
                }

                // Ask user if they want to keep playing
                System.out.print("Would you like to play against another opponent? (y/n) ");
                if (!InputValidator.askUserYesNo()) {
                    break;
                }
            }



        }

        // Exit message
        System.out.println("\nGoodbye! ");
    }
}
