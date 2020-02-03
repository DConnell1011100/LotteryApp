
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
        int [] secretNumbers;
        int [][] userNumbers;
        boolean withinRange;
        int n;
        int test;
        boolean userNumberDuplicate;
        
        
        Scanner input = new Scanner(System.in);
        
        Lottery myLott = new Lottery();
        
        //ask home many lines the user wants to play
        do{
            System.out.println("How many lines would you like to play?");
            n = input.nextInt();
            myLott.withinRange(n, 1, 3);
            withinRange = myLott.getWithinRange();
        }
        while(withinRange == false);
        
        myLott.setNoOfLines(n);
     
        
        userNumbers = new int[myLott.getNoOfLines()][6];
        myLott.createSecretNumbers();
        secretNumbers = myLott.getSecretNumbers();
        
        for(int i = 0; i < 6; i++){
            System.out.print(secretNumbers[i]+" ");
        }
        System.out.println("");
        
        for(int i = 0; i < userNumbers.length; i++){
            for(int j = 0; j < userNumbers[i].length; j++){
                int currentLineNumber = i;
                System.out.println("Entry for line " + (i+1) + " number " +(j+1) + ": ");
                myLott.withinRange(input.nextInt(), 1, 40);
                withinRange = myLott.getWithinRange();
                if(withinRange == true){
                    myLott.setUserNumbers(userNumbers[i][j], currentLineNumber);
                    userNumberDuplicate = myLott.getUserNumberDuplicate();
                    if(userNumberDuplicate = true){
                        System.out.println("Cannot enter duplicate numbers");
                        j--;
                    }
                }
                else{
                    System.out.println("That is not a number between 1-40");
                    j--;
                }
            }
        }
    }
    
}