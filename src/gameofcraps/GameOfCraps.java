package gameofcraps;

import java.util.Random;
import java.util.Scanner;

/**
*
* @author C. Dierbach
*/
public class GameOfCraps {

   public static void main(String[] args) {

       int wager;
       int human_winnings = 0;
       int computer_winnings = 0;
       int num_games_to_play;
       
       final int MAX_WAGER = 100;
       Dice dice;

       num_games_to_play = promptForNumGames();
       for(int i = 1; i <= num_games_to_play; i++){

           // HUMAN'S ROUND
           wager = getHumansWager(MAX_WAGER);
           dice = new Dice();
           System.out.println("Your Rolls...");
           playRound(dice);

           if(dice.getState() instanceof Win)
               human_winnings = human_winnings + wager;
           else
               human_winnings = human_winnings - wager;

           // COMPUTER'S ROUND
           wager = randomly_generate(MAX_WAGER);
           System.out.println("I wager: " + wager);
           dice = new Dice();
           System.out.println("Now it is my turn...");
           playRound(dice);

           if(dice.getState() instanceof Win)
               computer_winnings = computer_winnings + wager;
           else
               computer_winnings = computer_winnings - wager;
       }
       
       System.out.println("Your winnings:" + human_winnings);
       System.out.println("Computer's winnings:" + computer_winnings);
   } 
       
   public static int promptForNumGames(){
	   int gamesToPlay = 0;
	   do {
		   System.out.println("Enter the amount of games you wish to play: ");
		   Scanner input = new Scanner(System.in);
		   gamesToPlay = input.nextInt();
	   }while(gamesToPlay <= 0);
	   
	   
	return gamesToPlay;   }

   public static int getHumansWager(int max_wager){
	   
	   int wagerMade = 0;
	   
	   do {
		   System.out.println("Enter an amount you wish to wager for this round: ");
		   Scanner input = new Scanner(System.in);
		   wagerMade = input.nextInt();
	   }while(wagerMade <= 0 || wagerMade > max_wager);
	   
	   
	   return wagerMade;  
	   
   }
   // prompts for and returns wager between 1 and max_wager dollars

   public static int randomly_generate(int max){
	   int computerWager = 0;
	   Random rand = new Random();
	   do {
		   computerWager = rand.nextInt(max) +1;
	   }while(computerWager <= 0 || computerWager > max);
	   
	   
	return computerWager;  }
   // generates random integer between 1 and max

   public static void playRound(Dice dice){
   // play until win or loss occurs
       while(!(dice.getState() instanceof Win) &&
             !(dice.getState() instanceof Loss))
           dice.rollDice();
       
       if(dice.getState() instanceof Win)
    	   System.out.println("Won on a roll of: "+ dice.getCurrentRoll()+ "!");
       else if(dice.getState() instanceof Loss)
    	   System.out.println("Loss on a roll of: "+ dice.getCurrentRoll()+ ", better luck next time.");
   }
}
