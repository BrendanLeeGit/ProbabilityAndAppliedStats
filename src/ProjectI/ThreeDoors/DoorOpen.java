package ProjectI.ThreeDoors;
import java.util.Random;
public class DoorOpen {
    private int guess;
    private int pastGuess;
    private int answer;
    private int revealedDoor;

    /**
     * Begins running the simulation of the three doors game.
     *
     * @param games         The # of games played. The higher the number, the higher the accuracy
     * @param switchDoor    Whether you want the chosen door to be switched after the reveal or not. True means switch
     * @return              Returns total wins divided by the # of games
     */
    public double playGames(int games, boolean switchDoor) {
        Random rand = new Random();
        double wins = 0;
        for (int i = 0; i < games; i++) {
            //Randomly choose the door with the car and the guess, represented by 0, 1, and 2
            guess = rand.nextInt(3);
            pastGuess = guess;
            answer = rand.nextInt(3);
            //Continually generate random number that doesn't match guess or answer to choose which door to reveal
            for (;;){
                revealedDoor = rand.nextInt(3);
                if (revealedDoor != guess && revealedDoor != answer){
                    break;
                }
            }
            //changes guess to the only other possible door
            if (switchDoor){
                guess = 3 - revealedDoor - pastGuess;
            }
            //increments win counter if the guess is correct
            if (guess == answer){
                wins++;
            }
        }
        return wins/(double)games;
    }
}
