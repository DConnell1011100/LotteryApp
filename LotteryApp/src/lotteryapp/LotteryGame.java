
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
        int [][] userNumbers;
        boolean withinRange;
        int noOfLines;
        int[] secretNumbers;
        int matches[][];
        int invalidEntry;
        int currentLineNo;
        int currentNumber;
        boolean playAgain;
        int [][] winningsPerLine;
        Lottery myLott[] = new Lottery[100];
        Scanner input = new Scanner(System.in);
        
        
        int gameNo = 0;
        do{
                           myLott[gameNo] = new Lottery();
        //ask how many lines the user wants to play
        
            do{
                System.out.println("How many lines would you like to play?");
                noOfLines = input.nextInt();
                myLott[gameNo].setNoOfLines(noOfLines);
                withinRange = myLott[gameNo].getWithinRange();
            }
            while(withinRange == false);


            myLott[gameNo].createSecretNumbers();
            secretNumbers = myLott[gameNo].getSecretNumbers();

            System.out.print("Lottery Numbers: ");
            for(int i = 0; i < secretNumbers.length; i++){          
                System.out.print(myLott[gameNo].getSecretNumbers()[i]+ " ");
            }

            //initialize user's input with number of lines (rows) and 6 numbers per line(column)
            userNumbers = new int[noOfLines][6];
            //get user input 
            //set the current line number to 0 to start.
            currentLineNo = 0;
            do{
                do{
                System.out.println("Entry for line " + (currentLineNo+1) + " number 1: ");
                currentNumber = input.nextInt();
                myLott[gameNo].withinRange(currentNumber);
                withinRange = myLott[gameNo].getWithinRange();
                if(withinRange == true){
                    userNumbers[currentLineNo][0] = currentNumber;
                }
                else{
                    System.out.println("Not a number between 1-40");
                }
                }while(withinRange == false);
                for(int i = 1; i < 6;){
                    invalidEntry = 1;
                    //ask the user input
                    System.out.println("Entry for line " + (currentLineNo+1) + " number " +(i+1) + ": ");
                    currentNumber = input.nextInt();
                    for(int j = 0; j < i; j++){
                        //check if number is within range
                        myLott[gameNo].withinRange(currentNumber);
                        //get the result of that check
                        withinRange = myLott[gameNo].getWithinRange();
                        //if withinRange if false, print out of range number
                        if(withinRange == false){
                            System.out.println("Not a number between 1-40");
                            invalidEntry = 0;
                            break;
                        }
                        else if(withinRange == true){
                            if(currentNumber == userNumbers[currentLineNo][j]){
                                invalidEntry = 0;
                                System.out.println("Duplicate Number");
                                break;
                            }
                        }
                    }//end of j loop
                    if(invalidEntry == 1){
                        userNumbers[currentLineNo][i] = currentNumber;
                        i++;
                    }
                }//end of i loop
                currentLineNo++;
            }while(currentLineNo < myLott[gameNo].getNoOfLines());//stop repeating when all line numbers are filled

            myLott[gameNo].setUserNumbers(userNumbers);


            myLott[gameNo].checkMatches();

            matches = myLott[gameNo].getMatches();

            for(int i = 0; i < matches.length; i++){
                for(int j = 0; j < matches[i].length; j++){
                    System.out.println("Matches on line " + (i+1) + ": " + myLott[gameNo].getMatches()[i][j]);
                }
            }
            myLott[gameNo].calculateWinnings();
            winningsPerLine = new int[myLott[gameNo].getNoOfLines()][1];
            winningsPerLine = myLott[gameNo].getWinningsPerLine();
            secretNumbers = myLott[gameNo].getSecretNumbers();
            System.out.println("Winnings: ");
            for(int i = 0; i < winningsPerLine.length; i++){
                for(int j = 0; j < winningsPerLine[i].length; j++){
                    System.out.println("Line "+(i+1)+ " winnings: "+ winningsPerLine[i][j]);
                }
            }
            
            System.out.print("Lottery Numbers: ");
            for(int i = 0; i < secretNumbers.length; i++){          
                System.out.print(myLott[gameNo].getSecretNumbers()[i]+ " ");
            }
            System.out.println("\nDo you want to play again?");
            input.nextLine();//fix for the nextInt scanner issue
            String play = input.nextLine();
            if(play.equalsIgnoreCase("Yes") || play.equalsIgnoreCase("Y")){
                playAgain = true;
            }
            else{
                System.out.println("Thank you for playing! Game over.");
                playAgain = false;
            }
            gameNo++;
        }while(playAgain == true);
        
        
    }
    
}