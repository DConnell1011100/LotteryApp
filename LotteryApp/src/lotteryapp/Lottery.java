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
    
    //method to call to set the first number of each line
    public void setFirstNumber(int line, int number){
        userNumbers = new int[getNoOfLines()][6];
        userNumbers[line][0] = number;
    }
    //call a new set method for the rest of the numbers which will compare the number passed in to the other numbers in the line
    public void setUserNumbers(int lineNo, int number) {
        //start the count at 1 because we already have the first number
        for(int i = 1; i < userNumbers.length; i++){
            int n = number;
            int line = lineNo;
            for(int j = 0; j < i; j++){
                if(n == userNumbers[line][j]){
                    duplicateInput = true;
                    i--;
                }
                else if(n != userNumbers[line][j]){
                    userNumbers[line][i] = n;
                    duplicateInput = false;
                }
            }
        }
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
