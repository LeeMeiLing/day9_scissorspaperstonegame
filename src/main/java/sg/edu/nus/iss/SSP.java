package sg.edu.nus.iss;

import java.util.Random;

public class SSP {
    
    public Integer generateComputerChoice() {

        Random rand = new Random();
        return rand.nextInt(3);
    }

    public String checkWinner(Integer playerChoice, Integer computerChoice){

        playerChoice = playerChoice -1;
        String winner = "";

        if(playerChoice.equals(computerChoice)){
            return "";
        }

        switch(playerChoice){

            //scissors
            case 0: {
                if(computerChoice == 1){
                    winner = "player";
                }else if(computerChoice == 2){
                    winner = "computer";
                }
                break;
            }
            //paper
            case 1:{
                if(computerChoice == 2){
                    winner = "player";
                }else if(computerChoice == 0){
                    winner = "computer";
                }
                break;
            }


            //stone
            case 2:{
                if(computerChoice == 0){
                    winner = "player";
                }else if(computerChoice == 1){
                    winner = "computer";
                }
                break;
            }
        }

        return winner;

    }
}
