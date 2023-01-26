package sg.edu.nus.iss;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        Integer computerChoice, playerChoice = 0;
        String winner = "";

        Scanner scanner= new Scanner(System.in);

        SSP ssp = new SSP();
        computerChoice = ssp.generateComputerChoice();

        while(winner.equals("")){

            System.out.println("Enter (1)Scissors, (2) Paper, or (3) Stone: ");
            
            try{

                playerChoice = scanner.nextInt();

            }catch(InputMismatchException e){

                System.out.println("Invalid input: Only number 1, 2 or 3 is allowed");
                scanner.skip(Pattern.compile(".*")); /// must have this line, else the char will stay in scanner and cannot complete scanner.nextInt
                continue;
            }

            if(!((playerChoice >= 1) && (playerChoice<=3))){
                System.out.println("Invalid input: Only number 1, 2 or 3 is allowed");
                continue;
            }

            winner = ssp.checkWinner(playerChoice, computerChoice);
            if(winner.equalsIgnoreCase("player")){
                System.out.println("You won!");
            }else if(winner.equalsIgnoreCase("computer")){
                System.out.println("You lost!");
            }else{
                System.out.println("It's a tie!");
            }

        }

        scanner.close();
    }
    
}
