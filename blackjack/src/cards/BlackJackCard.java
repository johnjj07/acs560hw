package cards;

import cards.CardDetails.FaceValue;
import cards.CardDetails.Suit;

public class BlackJackCard extends Card{
	
	private int cardValue;
	private boolean isAce;
	private boolean isFace;
	private final int MIN_VALUE = 1;
	private final int MAX_VALUE = 11;
	
	public BlackJackCard(FaceValue value, Suit suit) {
		super(value, suit);
		setValue();
		super.setValue(cardValue);
	}
	
	private void setValue() {
		switch(faceValue){
			case ACE:	cardValue = 11;
						isAce = true;
						break;
			case TWO:	cardValue = 2;
						break;
			case THREE:	cardValue = 3;
						break;
			case FOUR:	cardValue = 4;
						break;
			case FIVE:	cardValue = 5;
						break;
			case SIX:	cardValue = 6;
						break;
			case SEVEN:	cardValue = 7;
						break;
			case EIGHT:	cardValue = 8;
						break;
			case NINE:	cardValue = 9;
						break;
			case TEN:	cardValue = 10;
						break;
			default:	cardValue = 10;
						isFace = true;
		}
	}
	
	public void setAceToOne() {
		if(isAce){
			cardValue = MIN_VALUE;
			super.setValue(cardValue);
		}
	}
	
	public int getValue() {
		return cardValue;
	}
	
	public boolean isAce() {
		return isAce;
	}
	
	public boolean isFace() {
		return isFace;
	}

}
