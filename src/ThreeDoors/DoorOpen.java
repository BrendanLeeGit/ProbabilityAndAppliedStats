package ThreeDoors;
import java.util.Random;
public class DoorOpen {
    int guess;
    int pastGuess;
    int answer;
    int revealedDoor;
    Random rand = new Random();

    public double playGames(int games, boolean switchDoor) {
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
