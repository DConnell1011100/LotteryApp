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
    private boolean userNumberDuplicate;
    
    public void setNoOfLines(int noOfLines) {
        this.noOfLines = noOfLines;
    }
    
    public void setUserNumbers(int number, int currentLineNumber) {
        userNumbers = new int[noOfLines][6];
        userNumbers[currentLineNumber][0] = number;
        for(int i = 1; i < 6; i++){
            for(int j = 0; j <= i; j++){
                if(number != userNumbers[currentLineNumber][j]){
                    userNumbers[currentLineNumber][i] = number;
                    userNumberDuplicate = false;
                }
                else{
                    i--;
                    userNumberDuplicate = true;
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
        for(int i = 1; i < 6;i ++){
            n = myRan.nextInt(40);
            n += 1;
            for(int j = 0; j < i; j++){
                if(n != secretNumbers[j]){
                    secretNumbers[i] = n;
                }
                else{
                    i--;
                }
            }
        }
            
    }
     


    public void withinRange(int number, int low, int high){
        if (number >= low && number <= high) {
            withinRange = true;
        } else {
            withinRange = false;
            System.out.println("That is not a number between " + low + " and " + high);
        }
    }
    
    public void eliminateDuplicateUserInput(int currentLinePosition, int currentNumberPosition, int currentNumberValue){
        for(int i = 0; i < currentLinePosition; i++){
            for(int j = 0; i < currentNumberPosition; i++){
                if(currentNumberValue != userNumbers[i][j]){
                    userNumberDuplicate = false;
                }
                else{
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
    
    public boolean getUserNumberDuplicate(){
        return userNumberDuplicate;
    }
    
}