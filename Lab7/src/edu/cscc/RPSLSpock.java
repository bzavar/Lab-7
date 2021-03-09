package edu.cscc;
import java.util.Random;

/**
 * RSPSLSpock Game: generate a RPSLSpock computer pick to play against player's manual input, verify player's input
 * @author Brenna Zavar
 */
public class RPSLSpock {

    static Random rand = new Random(System.currentTimeMillis());

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    public static final String LIZARD = "lizard";
    public static final String SPOCK = "spock";
    public static final String bananaERROR = "banana"; // Added to test for error

    /**
     * Validate user entry to match one of five options
     * @param pick user input
     * @return the valid matching pick, or false
     */
    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }

    /**
     * Generate a computer pick
     * @return random one of five options
     */
    public static String generatePick() {
        String pick = null;
        switch (rand.nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }

    /**
     * Determine if computer wins or false
     * @param c_pick Computer's pick
     * @param h_pick Human's pick
     * @return Computer win (true), or human win (false)
     */
    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}