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
    private int duplicateInput;
    private int matches[][];
    private int winningsPerLine[][];

    public void setNoOfLines(int noOfLines) {
        if (noOfLines >= 1 && noOfLines <= 3) {
            this.noOfLines = noOfLines;
            withinRange = true;
        } else {
            System.out.println("Please enter a number between 1-3");
            withinRange = false;
        }
    }
    
    
    //call a new set method for the rest of the numbers which will compare the number passed in to the other numbers in the line
    public void setUserNumbers(int[][] numbers) {
        //start the count at 1 because we already have the first number
        userNumbers = new int[getNoOfLines()][6];
        userNumbers = numbers;
    }
    
    public void createSecretNumbers() {
        secretNumbers = new int[6];
        Random myRan = new Random();
        int n = myRan.nextInt(40);
        n += 1;
        secretNumbers[0] = n;
        int duplicate;
        for (int i = 1; i < secretNumbers.length;) {
            duplicate = 1;
            n = myRan.nextInt(40);
            n += 1;
            for (int j = 0; j < i; j++) {
                if (n == secretNumbers[j]) {
                    duplicate = 0;
                    break;
                } //end of if
            }//end of inner loop
            if(duplicate == 1){
                secretNumbers[i] = n;
                i++;
            }
        }//end of outer loop
    }//end of method

    public void checkMatches(){
        int counter = 0;
        do{
            matches = new int [noOfLines][1];
            for(int i = 0; i < secretNumbers.length; i++){
                for(int j = 0; j < userNumbers.length; j++){
                    for(int k = 0; k < userNumbers[j].length; k++){
                        if(userNumbers[j][k] == secretNumbers[i]){
                            matches[counter][0] += 1;
                        }
                    }
                }
            }
            counter++;
        }while(counter < getNoOfLines());
    }
    
    public void calculateWinnings(){
        int counter = 0;
        do{
            winningsPerLine = new int [counter][1];
            for(int i = 0; i < matches.length; i++){
                for(int j = 0; j < matches[i].length; j++){
                    if(matches[i][j] == 3){
                        winningsPerLine[i][j] = 125;
                    }
                    else if(matches[i][j]==4){
                        winningsPerLine[i][j] = 300;
                    }
                    else if(matches[i][j]==5){
                        winningsPerLine[i][j] = 1500;
                    }
                    else if(matches[i][j]==6){
                        winningsPerLine[i][j] = 10000;
                    }
                }
            }
        }while(counter < getNoOfLines());
    }
    
    public int [][] getWinningsPerLine(){
        return winningsPerLine;
    }
    
    
    public void withinRange(int number) {
        withinRange = number >= 1 && number <= 40;
    }
    
    public int [][] getMatches(){
        return matches;
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

    public int getDuplicateInput() {
        return duplicateInput;
    }

}
