package textCheck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextCheckTest {
    //Testar att antal tecken räknas korrekt
    @Test
    public void characterCountTest() {
        //Arrange
        TextCheck check = new TextCheck();
        String userInput1 = "Hello";
        String userInput2 = "Here are words";
        int expectedCount = 17;

        //Act
        check.checkInput(userInput1);
        check.checkInput(userInput2);
        int actualCount = check.getNumOfCharacters();

        //Assert
        assertEquals(expectedCount, actualCount);
    }

    //Testar att antal rader räknas korrekt
    @Test
    public void lineCountTest() {
        //Arrange
        TextCheck check = new TextCheck();
        String userInput1 = "One line";
        String userInput2 = "Two lines";
        int expectedCount = 2;

        //Act
        check.checkInput(userInput1);
        check.checkInput(userInput2);
        int actualCount = check.getNumOfLines();

        //Assert
        assertEquals(expectedCount, actualCount);

    }

    //Testar att antal ord räknas korrekt
    @Test
    public void wordCountTest() {
        //Arrange
        TextCheck check = new TextCheck();
        String userInput1 = "Three good words";
        String userInput2 = "Another three words";
        int expectedCount = 6;

        //Act
        check.checkInput(userInput1);
        check.checkInput(userInput2);
        int actualCount = check.getNumOfWords();

        //Assert
        assertEquals(expectedCount, actualCount);
    }

    //Testar att längsta ordet registreras korrekt
    @Test
    public void longestWordTest() {
        //Arrange
        TextCheck check = new TextCheck();
        String expectedLongest = "reallylongword";
        String userInput1 = "This is a " + expectedLongest;
        String userInput2 = "A short word";

        //Act
        check.checkInput(userInput1);
        check.checkInput(userInput2);
        String actualLongest = check.getLongestWord();

        //Assert
        assertEquals(expectedLongest, actualLongest);
    }

    //Testar att checkInput returnerar false vid "stop"
    @Test
    public void stopTest() {
        //Arrange
        TextCheck check = new TextCheck();
        String userInput = "stop";
        boolean expected = false;

        //Act
        boolean actual = check.checkInput(userInput);

        //Assert
        assertEquals(expected, actual);
    }

    //Testar att rader räknas vid tom sträng, men ej tecken och ord
    @Test
    public void emptyStringTest() {
        //Arrange
        TextCheck check = new TextCheck();
        String userInput1 = "";
        String userInput2 = "   ";
        int expectedCharacterCount = 0;
        int expectedLineCount = 2;
        int expectedWordCount = 0;
        String expectedLongest = "";

        //Act
        check.checkInput(userInput1);
        check.checkInput(userInput2);
        int actualCharacterCount = check.getNumOfCharacters();
        int actualLineCount = check.getNumOfLines();
        int actualWordCount = check.getNumOfWords();
        String actualLongest = check.getLongestWord();

        //Assert
        assertEquals(expectedCharacterCount, actualCharacterCount);
        assertEquals(expectedLineCount, actualLineCount);
        assertEquals(expectedWordCount, actualWordCount);
        assertEquals(expectedLongest, actualLongest);
    }
}
