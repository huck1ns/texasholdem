package texasholdem;
import java.util.ArrayList;

public class Pot {
	public int currentPot = 0;
	public ArrayList<Integer> bets = new ArrayList<>();

    Pot() {
    }
	
	// adds bets to ArrayList and currentPot
	
	public void addBet(int bet) {
		bets.add(bet);
		currentPot += bet;
	}
	
	//Pays out from currentPot then resets the bets Arraylist
	
	public int payOut() {
		int pay = currentPot;
		currentPot = 0;
		bets.clear();
		
		return pay;
	}

	
	/*
	 * creates an array of the current round bets using the arraylist of currentPlayers(botCopy) to get the number of current players. 
	 */

	/*
	 * pairs with the currentBets method to return the highest bet of the round. Used for checking that all the bets match the highest. Useful for a player call method to make sure the player can't call lower than the highest bet
	 */
	public int highestBet(){
		int highest = 0;	

		for(int bet: bets) {
			if(highest<bet) {
				highest = bet;
			}

		}
		return highest;
	}
	public String toString() {
		String s="The current pot is: " + currentPot;
		return s;
	}
	
	//We'll need to reset the bets ArrayList after each mini-round since we don't want to carry over the lost mini-round's bets
	
	public void resetBets() {
		bets.clear();
	}

}
	

