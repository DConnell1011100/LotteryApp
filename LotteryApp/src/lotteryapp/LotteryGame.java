
package lotteryapp;
import java.util.Scanner;
/**
 *
 * @author Daniel
 */
public class LotteryGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //int [] secretNumbers;
        int [][] userNumbers;
        boolean withinRange = false;
        boolean userNumberDuplicate = true;
        
        
        Scanner input = new Scanner(System.in);
        
        Lottery myLott = new Lottery();
        
        //ask home many lines the user wants to play
        do{
            System.out.println("How many lines would you like to play?");
            myLott.setNoOfLines(input.nextInt());
            withinRange = myLott.getWithinRange();
        }
        while(withinRange == false);
        
     
        //initialize user's input with number of lines (rows) and 6 numbers per line(column)
        userNumbers = new int[myLott.getNoOfLines()][6];
        
        /*for testing purposes only - displays secret nuymb
        myLott.createSecretNumbers();
        secretNumbers = myLott.getSecretNumbers();
        
        
        for(int i = 0; i < 6; i++){
            System.out.print(secretNumbers[i]+" ");
        }
        System.out.println("");
        */
        //get user input 
        for(int i = 0; i < userNumbers.length; i++){
            for(int j = 0; j < userNumbers[i].length; j++){
                //declare a variable to store the currentNumber
                int currentNumber;
                //ask the user input
                do{
                    System.out.println("Entry for line " + (i+1) + " number " +(j+1) + ": ");
                    //store the input in currentVariable
                    currentNumber = input.nextInt();
                    //check if number is within range
                    myLott.withinRange(currentNumber);
                    //get the result of that check
                    withinRange = myLott.getWithinRange();
                    //if withinRange if false, print out of range number
                    if(!withinRange){
                        System.out.println("Not a number between 1-40");
                    }
                    //if it is within range, continue the verification process
                    else if(withinRange){
                        //call method to check if number has already been entered by passing in i(current line), j(current number position), and currentNumber
                        myLott.checkDuplicateInput(i, j, currentNumber);
                        //set the boolean by calling the result from the IC
                        userNumberDuplicate = myLott.getUserNumberDuplicate();
                        //if it is true, then tell user and repeat processs
                        if(userNumberDuplicate){
                            System.out.println("You cannot enter duplicate numbers in a line");
                        }
                        //if it is not a duplicate, end the do while and let the normal for loops increment
                        else if(!userNumberDuplicate){
                            //set user numbers here, and set them in the IC in case we need to call them later
                            userNumbers[i][j] = currentNumber;
                            myLott.setUserNumbers(currentNumber);
                        }
                    }
                    //do while loop when the number is not in range
                }while(withinRange == false || userNumberDuplicate == true);
                
                    
                
                
               
            }
        }
        
        for(int i = 0; i < userNumbers.length; i++){
            for(int j = 0; j < 6; j++){
                System.out.println(userNumbers[i][j]);
            }
        }
    }
    
}