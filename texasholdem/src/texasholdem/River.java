package texasholdem;
import java.util.ArrayList;
import java.util.Collections;


public class River {
	public ArrayList<Card> river;
	private final Game game;
	
	
	River(Game game) {
		this.game=game;
		this.river = new ArrayList<>();
	}
	
	public void riverCreate() {
		ArrayList<Card> river = new ArrayList<>();
		Card[] temp = game.deck.deal(3);
		Collections.addAll(river, temp);		
		this.river=river;
	}
	
	public void riverAdd() {
		Card[] temp = game.deck.deal(1);
		Collections.addAll(this.river, temp);		
	}
	
	public String toString() {
		StringBuilder river= new StringBuilder();
		for (int i=0; i<this.river.size(); i++) {
			if (i==this.river.size()-1) {
				river.append(this.river.get(i).toString());
			} else {
				river.append(this.river.get(i).toString()).append(", ");
			}
		}
		return river.toString();
	}
	
}

