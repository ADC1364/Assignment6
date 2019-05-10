package gameofcraps;

public class PointState extends State {
	// ------------------------------------------------------------------------
	// Second roll of dice:
//	    7 Loss ("seven out")
//	    match of previous roll Win ("hits the points")
//	    any other, roll again
	// ------------------------------------------------------------------------    
	    static private int points_to_match;

	    public PointState(State source) {
	        super(source);
	        points_to_match = source.getContext().getCurrentRoll();
	    }
	    
	    public PointState(Dice dice) {
	        super(dice);
	        System.out.println("** Invalid State Transition Exception **");
	        System.exit(0);
	    }

	    public void transitionState() { 
	    	
	    	int newRoll = getContext().getCurrentRoll();
	    	
	    	if(newRoll == 7) {
	    		
	    		getContext().setState(new Loss(this));
	    	}
	    	else if(points_to_match == newRoll) {
	    		getContext().setState(new Win(this));
	    	}
	    	else {
	    		getContext().rollDice();
	    	}
	    	
	    	
	    	
	    }
	    //  transitions to either a Win or Loss state    
	}
