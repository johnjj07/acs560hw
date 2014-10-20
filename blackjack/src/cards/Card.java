package cards;

import cards.CardDetails.FaceValue;
import cards.CardDetails.Suit;


public class Card {
	
	protected FaceValue faceValue;
	protected Suit suit;
	private boolean available = true;
	private int value;

	public Card(FaceValue value, Suit suit){
		faceValue = value;
		this.suit = suit;
	}
	
	public void markAvailable() {
		available = true;
	}
	
	public void markUnavailable() {
		available = false;
	}
	
	public boolean isCardAvailable() {
		return available;
	}
	
	public String printCardInformation() {
		return faceValue.getValue() + suit.getSuit();
	}
	
	protected void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isAce() {
		return faceValue == FaceValue.ACE;
	}
	
}
