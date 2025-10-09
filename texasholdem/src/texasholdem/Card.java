package texasholdem;

import javafx.scene.image.Image;
import java.io.InputStream;

public class Card {
	private final String suit;
	private final int value;
	private final Image image;
	
	/*
	Card is created with a suit and value, comes from deck class
	Technically only used by deck class with the proper values, but something could be done to ensure that only the
	proper values are accepted
	Image is hardcoded into class based on the suit and value, would have problems if incorrect values were passed
	 */
	Card(String suit, int value) {
		this.value=value;
		this.suit=suit;
		this.image=createImage();
	}

	//Return value of card
	public int getValue() {
		return value;
	}

	//Return suit of card
	public String getSuit() {
		return suit;
	}

	//retuns the image of the card
	public Image getImage() {
		return image;
	}

	//returns string of card in format "VALUE of SUIT"
	public String toString() {
		if (this.value<11) return (this.value+" of "+this.suit);
		if (this.value==11) return ("Jack of "+this.suit);
		if (this.value==12) return ("Queen of "+this.suit);
		if (this.value==13) return ("King of "+this.suit);
		if (this.value==14) return ("Ace of "+this.suit);
		else return "";
	}

	//Overrides equal, possible changes here, don't remember what the point of this is
	@Override
	public boolean equals(Object o) {
		if (this==o) return true;
		if (o==null || o.getClass() != getClass()) return false;
		Card card = (Card) o;
		return value==card.value && suit.equals(card.suit);
	}

	/*Reads suit and value to generate a standard file name, there must be a better practice that I could follow for
	this. Relies on the card files. Maybe when exported to exe, it would be combined to one file?
	 */
	private Image createImage() {
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

	//Returns the name of the file that the proper card image will be stored at
	private String imageName() {
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
