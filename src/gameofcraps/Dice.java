package gameofcraps;

import java.util.Random;

public class Dice {
	// Context class - current roll of the dice
	    
	    private int current_roll;
	    private State objState;

	    public Dice() {
	        objState = State.InitialState(this);
	    }

	    public void setState(State newState) {
	        objState = newState;
	    }

	    public State getState() {
	        return objState;
	    }

	    public int getCurrentRoll() {
	        return current_roll;
	    }

	    public void rollDice() {
	        current_roll = generateRoll();
	        System.out.println("rolled a " + current_roll);
	        objState.roll_dice();
	    }
	    
	    private int generateRoll(){
	    	
	    	Random  rand = new Random();
	    	
	    	int dice1 = rand.nextInt(6) + 1;
	    	int dice2 = rand.nextInt(6) + 1;
	    	
	    	int sum = dice1 + dice2;
	    	
	    	current_roll = sum;
	    	
	    	
			return current_roll;  }
	    // randmomly generated number between 2-12
	    
	}
