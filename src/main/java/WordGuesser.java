import java.util.ArrayList;
import java.util.Scanner;

public class WordGuesser {
    //variabler
    public String CorrectWord;
    public String GuessedCharacters;
    ArrayList<String> IncorrectlyGuessedCharacters = new ArrayList<String>();

    //scanner til at tage input fra brugeren
    Scanner scanner = new Scanner(System.in);

    //getters og setters
    public String getCorrectWord() {
        return CorrectWord;
    }

    public void setCorrectWord(String correctWord) {
        CorrectWord = correctWord;
    }

    public String getGuessedCharacters() {
        return GuessedCharacters;
    }

    public void setGuessedCharacters(String guessedCharacters) {
        GuessedCharacters = guessedCharacters;
    }

    public ArrayList<String> getIncorrectlyGuessedCharacters() {
        return IncorrectlyGuessedCharacters;
    }

    public void setIncorrectlyGuessedCharacters(ArrayList<String> incorrectlyGuessedCharacters) {
        IncorrectlyGuessedCharacters = incorrectlyGuessedCharacters;
    }


    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    //contructor til at lave et nyt objekt af med et ord og en string af gættede bogstaver
    public WordGuesser(String correctWord, String guessedCharacters) {
        CorrectWord = correctWord;
        GuessedCharacters = guessedCharacters;
    }

    //metode til at gætte ordet
    public void Guess() {
        //laver et nyt stringbuilder objekt med længden af ordet, som bliver brugt til at vise ordet med understregninger
        StringBuilder displayWord = new StringBuilder(CorrectWord.length());
        for (int i = 0; i < CorrectWord.length(); i++) {
            displayWord.append("_"); // Skriver dit ord ud med understregninger
        }
        //laver en boolean til at tjekke om ordet er gættet og sætter den til false
        boolean wordGuessed = false;
        //while loop der kører indtil ordet er gættet / wordGuessed er true
        while (!wordGuessed) {
            System.out.println("Sådan ser det ud nu: " + displayWord.toString());
            System.out.println("Gæt et bogstav papand: ");
            String guess = scanner.nextLine();

            if (GuessedCharacters.contains(guess)) {
                System.out.println("Kan du ikke huske?! Det har du gættet på..");
            } else if (CorrectWord.contains(guess)) {
                GuessedCharacters += guess;
                System.out.println("Rigtigt bogstav!!");

                // opdatere displayWord med det rigtige bogstav
                for (int i = 0; i < CorrectWord.length(); i++) {
                    if (CorrectWord.charAt(i) == guess.charAt(0)) {
                        displayWord.setCharAt(i, guess.charAt(0));
                    }
                }

                // Checker hvis ordet er gættet og hvis ja, går den ind i loopet og sætter wordGuessed til true som stopper while loopet
                if (displayWord.toString().equals(CorrectWord)) {
                    wordGuessed = true;
                    System.out.println("Tillykke! Du gættede ordet: " + CorrectWord);
                }
            } else {
                IncorrectlyGuessedCharacters.add(guess);
                System.out.println("FORKERT!!!");
            }
        }
    }


    public static void main(String[] args) {
        //sætter ordet og gættede bogstaver
        WordGuesser wordGuesser = new WordGuesser("michelleelskerheste", "");
        //kører metoden/spillet
        wordGuesser.Guess();
    }
}
