package sg.edu.nus.iss;

import java.util.Scanner;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        String[] choice = {"scissors", "paper", "stone"};
        Integer computerChoice, playerChoice;
        String winner = "";

        Scanner scanner= new Scanner(System.in);

        SSP ssp = new SSP();
        computerChoice = ssp.generateComputerChoice();

        while(winner.equals("")){

            System.out.println("Enter (1)Scissors, (2) Paper, or (3) Stone: ");
            playerChoice = scanner.nextInt();

            if(!(playerChoice >= 1) && (playerChoice<=3)){
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
