package textCheck;

public class TextCheck {
    private int numOfCharacters;
    private int numOfLines;
    private int numOfWords;
    private String longestWord;

    public TextCheck() {
        this.numOfCharacters = 0;
        this.numOfLines = 0;
        this.numOfWords = 0;
        this.longestWord = "";
    }

    public int getNumOfCharacters() {
        return numOfCharacters;
    }

    public int getNumOfLines() {
        return numOfLines;
    }

    public int getNumOfWords() {
        return numOfWords;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public boolean checkInput(String input) {
        //Tar bort eventuella inledande och avslutande mellanslag
        input = input.trim();

        //Returnerar false om användaren skrivit "stop", vilket i sin tur avslutar programmet
        if (input.equalsIgnoreCase("stop")) {
            return false;
        } else {
            //Om användaren ej skrivit stop:
            //Räknar rader (även tomma)
            //Om raden ej är tom räknas tecken och ord via checkCharacters() och checkWords()
            //Returnerar true, programmet fortsätter
            numOfLines++;
            if (!input.isEmpty()) {
                checkCharacters(input);
                checkWords(input);
            }
            return true;
        }
    }

    private void checkCharacters(String input) {
        //Tar bort eventuella blanksteg i användarinput och räknar antal tecken
        int characterCount = input.replaceAll("\\s+", "").length();
        numOfCharacters += characterCount;
    }

    private void checkWords(String input) {
        //Gör om användarinput till en String-array som lagrar orden separerade med blanksteg
        //Räknar antal ord
        String[] words = input.split("\\s+");
        int wordCount = words.length;
        numOfWords += wordCount;

        //Går igenom orden i arrayen och sätter längsta ordet om ett ord är längre än det nuvarande längsta ordet
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

    }
}
