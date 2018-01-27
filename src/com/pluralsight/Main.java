package com.pluralsight;

public class Main {

    /*
    https://programmingbydoing.com/
    Hangman - Assignment #153
     */

    //Instantiate the hidden word
    private static HiddenWord word = new HiddenWord();
    private static int count = 0;

    public static void main(String[] args) {

        //Fill one array with the full word and another with blanks for display
        word.createHiddenWord();
        word.createDisplayWord();

        //Establish the max chances for the user to guess the word
        int maxCount = word.getMaxCount();

        System.out.println();
        System.out.println("Can you guess the word with only " + maxCount + " chances?");
        System.out.println(word.getDisplayWord());
        System.out.println();

        //Play the game until the chances are gone or the user wins
        do {
            playGame();
        } while (!(word.gameFinished()) && count < maxCount);

        if (count >= maxCount){
            System.out.println("Game Over. You ran out of chances!");
            System.out.println("The word was " + word.getHiddenWord());
        }
    }

    private static void playGame(){
        //Prompt the user for a letter which can be compared against those in the array
        System.out.println("Enter a letter:");
        word.validateUserLetter();

        //Compare the user's letter against those in the array
        word.compareLetter(word.getUserLetter());

        //Display the user's progress
        System.out.println((word.getDisplayWord()));
        System.out.println();
        count++;
        System.out.println("You have used the following letters: " + word.displayUsedLetters());
    }
}
