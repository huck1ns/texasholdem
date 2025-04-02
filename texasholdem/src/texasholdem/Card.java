package texasholdem;

import javafx.scene.image.Image;
import java.io.InputStream;

public class Card {
	private final String suit;
	private final int value;
	private final Image image;
	
	
	Card(String suit, int value) {
		this.value=value;
		this.suit=suit;
		this.image=createImage();
	}
	
	public int getValue() {
		return value;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public Image getImage() {
		return image;
	}
	
	public String toString() {
		if (this.value<11) return (this.value+" of "+this.suit);
		if (this.value==11) return ("Jack of "+this.suit);
		if (this.value==12) return ("Queen of "+this.suit);
		if (this.value==13) return ("King of "+this.suit);
		if (this.value==14) return ("Ace of "+this.suit);
		else return "";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o) return true;
		if (o==null || o.getClass() != getClass()) return false;
		Card card = (Card) o;
		return value==card.value && suit.equals(card.suit);
	}
	
	public Image createImage() {
		String path= "/"+imageName();
		try {
			InputStream stream= getClass().getResourceAsStream(path);
			if (stream == null) {
				System.err.print("Couldn't find image"+path);
				return new Image("/card_placeholder.png");
			}
			return new Image(stream);
		} catch (Exception e){
			return new Image("/card_placeholder.png");
		}
	}
	
	public String imageName() {
		String valueName = switch (this.value) {
            case (11) -> "jack";
            case (12) -> "queen";
            case (13) -> "king";
            case (14) -> "ace";
            default -> String.valueOf(this.value);
        };
        return (valueName+"_of_"+this.suit+".png");
	}
}
