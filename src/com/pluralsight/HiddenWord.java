package com.pluralsight;

import java.util.Scanner;

public class HiddenWord {

    //Store a word for the user to guess
    private String word = "INCONCEIVABLE";

    //Create arrays to hold the letters for the full word and the hidden copy
    private String[] hiddenWord = new String[word.length()];
    private String[] displayWord = new String[word.length()];

    //Create variables to hold the current chosen letter and all chosen letters
    private char currentLetter;
    private String usedLetters = "";

    public int getMaxCount() {
        //Create a max number of chances for the user to guess the full word
        int maxCount = 15;
        return maxCount;
    }

    public void createHiddenWord() {
        //Fill an array with the letters from the word
        for (int index = 0; index < word.length(); index++){
            hiddenWord[index] = String.valueOf(word.charAt(index));
        }
    }

    public void createDisplayWord() {
        //Fill an array with _'s so the user sees the length of the word
        //and the remaining spaces as they guess letters
        for (int index = 0; index < displayWord.length; index++) {
            displayWord[index] = " _ ";
        }
    }

    public void validateUserLetter() {
        //Determine if the users entry was a character AND only a single character
        Scanner keyboard = new Scanner(System.in);
        do {
            String userEntry = keyboard.next();
            if (userEntry.length() == 1) {
                char userLetter = userEntry.charAt(0);
                if (Character.isLetter(userLetter)) {
                    this.currentLetter = userLetter;
                    break;
                } else {
                    System.out.println("Must be a letter. Try again");
                }
            } else {
                System.out.println("Must be a single letter. Try again");
            }
        } while (true);
    }

    public char getUserLetter() {
        return this.currentLetter;
    }

    public void compareLetter(char userLetter) {
        //Compare the user's letter against those in the word and display an updated copy of the word
        int index = 0;
        while (index < hiddenWord.length) {
            if (hiddenWord[index].equalsIgnoreCase(String.valueOf(userLetter))) {
                displayWord[index] = String.valueOf(userLetter).toUpperCase();
                index++;
            } else {
                index++;
            }
        }
    }

    public String displayUsedLetters() {
        //Track the letters chosen by the user
        usedLetters = usedLetters + " " + currentLetter;
        return usedLetters;
    }

    public String getDisplayWord() {
        //Convert the users copy of the word array to a string
        StringBuilder sb = new StringBuilder(displayWord.length);
        for (int index = 0; index < displayWord.length; index++) {
            sb.append(displayWord[index]);
        }
        return sb.toString();
    }


    public boolean gameFinished() {
        //Determine if the users copy of the word matches the hidden word
        if (getDisplayWord().equals(getHiddenWord())) {
            System.out.println("Game Over. You win!");
            return true;
        }
        return false;
    }

    public String getHiddenWord() {
        //Convert the hidden word array to a string
        StringBuilder sb = new StringBuilder(hiddenWord.length);
        for (int index = 0; index < hiddenWord.length; index++) {
            sb.append(hiddenWord[index]);
        }
        return sb.toString();
    }
}
