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
    private boolean duplicateInput;
    private int matches;

    public void setNoOfLines(int noOfLines) {
        if (noOfLines >= 1 && noOfLines <= 3) {
            this.noOfLines = noOfLines;
            withinRange = true;
        } else {
            System.out.println("Please enter a number between 1-3");
            withinRange = false;
        }
    }

    public void setUserNumbers(int [][] numbers) {
        userNumbers = numbers;
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

    
    
    public void checkMatches(){
        matches = 0;
        for(int i = 0; i < secretNumbers.length; i++){
            for(int j = 0; j < userNumbers.length; j++){
                for(int k = 0; k < userNumbers[j].length; k++){
                    if(userNumbers[j][k] == secretNumbers[i]){
                        matches++;
                    }
                }
            }
        }
    }
    public int getMatches(){
        return matches;
    }
    public void withinRange(int number) {
        withinRange = number >= 1 && number <= 40;
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
        return duplicateInput;
    }

}
