package lotteryapp;

import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Lottery {

    //instance variables
    private int[] secretNumbers;
    private int[][] userNumbers;
    private int noOfLines;
    private boolean withinRange;
    private boolean userNumberDuplicate = false;

    public void setNoOfLines(int noOfLines) {
        if (noOfLines >= 1 && noOfLines <= 3) {
            this.noOfLines = noOfLines;
            withinRange = true;
        } else {
            System.out.println("Please enter a number between 1-3");
            withinRange = false;
        }
    }

    public void setUserNumbers(int number) {
        userNumbers = new int[noOfLines][6];

    }

    public void withinRange(int number) {
        withinRange = number >= 1 && number <= 40;
    }

    public void createSecretNumbers() {
        secretNumbers = new int[6];
        Random myRan = new Random();
        int n = myRan.nextInt(40);
        n += 1;
        secretNumbers[0] = n;
        for (int i = 1; i < 6; i++) {
            n = myRan.nextInt(40);
            n += 1;
            for (int j = 0; j < i; j++) {
                if (n != secretNumbers[j]) {
                    secretNumbers[i] = n;
                } else {
                    i--;
                }
            }
        }

    }

    public void checkDuplicateInput(int currentLinePosition, int currentNumberPosition, int currentNumberValue) {
        for (int i = 0; i < currentLinePosition; i++) {
            for (int j = 0; i < currentNumberPosition; i++) {
                if (currentNumberValue != userNumbers[i][j]) {
                    userNumberDuplicate = false;
                } else {
                    userNumberDuplicate = true;
                }
            }
        }
    }

    public boolean getWithinRange() {
        return withinRange;
    }

    public int[][] getUserNumbers() {
        return userNumbers;
    }

    public int getNoOfLines() {
        return noOfLines;
    }

    public int[] getSecretNumbers() {
        return secretNumbers;
    }

    public boolean getUserNumberDuplicate() {
        return userNumberDuplicate;
    }

}
