package wordguessing;

import java.util.Arrays;
import java.util.Random;

public class Wordguessing {

    private final String[] wordlist = {"computer", "system", "java", "socket", "distributed"};
    private String actualWord;
    private boolean gameOver;

    public Wordguessing() {
        int i = new Random().nextInt(wordlist.length);
        actualWord = wordlist[i];
        gameOver = false;
    }

    public String getLetters() {
        if (gameOver) {
            int i = new Random().nextInt(wordlist.length);
            actualWord = wordlist[i];
            gameOver = false;
        }
        char[] letters = actualWord.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
    
    public String guessWord(String guess){
        if (gameOver){
            return "You must ask for new letters.";
        }
        System.out.println("acutal Word: <" + actualWord + ">");
        System.out.println("guess: <" + guess + ">");
        if (guess.equalsIgnoreCase(actualWord)){
            gameOver = true;
            return "Gratulation. You have won. Ask for a new word.";
        }
        return "Sorry. This is not the correct word.";
    }
}
