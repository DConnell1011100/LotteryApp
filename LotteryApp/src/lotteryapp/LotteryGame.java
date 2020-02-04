
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
        boolean withinRange;
        int[] secretNumbers;
        int matches;
        
        
        Scanner input = new Scanner(System.in);
        
        Lottery myLott = new Lottery();
        
        //ask home many lines the user wants to play
        do{
            System.out.println("How many lines would you like to play?");
            myLott.setNoOfLines(input.nextInt());
            withinRange = myLott.getWithinRange();
        }
        while(withinRange == false);
        
        
        myLott.createSecretNumbers();
        secretNumbers = myLott.getSecretNumbers();

        for(int i = 0; i < secretNumbers.length; i++){          
            System.out.print(myLott.getSecretNumbers()[i]+ " ");
        }
        
     
        //initialize user's input with number of lines (rows) and 6 numbers per line(column)
        userNumbers = new int[myLott.getNoOfLines()][6];
        
        //get user input 
        for(int i = 0; i < userNumbers.length; i++){
            for(int j = 0; j < userNumbers[i].length; j++){
                //declare a variable to store the currentNumber
                int currentNumber;
                //ask the user input
                System.out.println("Entry for line " + (i+1) + " number " +(j+1) + ": ");
                //store the input in currentVariable
                currentNumber = input.nextInt();
                //check if number is within range
                myLott.withinRange(currentNumber);
                //get the result of that check
                withinRange = myLott.getWithinRange();
                //if withinRange if false, print out of range number
                if(withinRange == false){
                    System.out.println("Not a number between 1-40");
                    j--;
                }
                else{
                    userNumbers[i][j] = currentNumber;
                }
            }
        }
        myLott.setUserNumbers(userNumbers);
        myLott.checkMatches();
        
        matches = myLott.getMatches();
        
      
        
        System.out.println("Matches:" +matches);
        
        
        for(int i = 0; i < userNumbers.length; i++){
            System.out.println(" ");
            for(int j = 0; j < userNumbers[i].length; j++){
                System.out.print(myLott.getUserNumbers()[i][j]+ " ");
            }
        }
    }
    
}