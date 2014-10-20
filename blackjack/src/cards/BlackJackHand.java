package cards;

import java.util.ArrayList;

public class BlackJackHand extends Hand implements Comparable<BlackJackHand>{
	
	private int score = 0;
	private final int BUST_POINT = 22;
	private boolean isBlackJack;
	private boolean hasAce = false;
	
	public BlackJackHand(Card firstCard, Card secondCard) {
		super(firstCard, secondCard);
		isBlackJack = getHandScore() == 21;
	}
	
	public int getHandScore() {
		int score = 0;
		for(Card card: cards) {
			score += card.getValue();
			if(card.isAce()){
				hasAce = true;
			}
		}
		this.score = score;
		return score;
	}
	
	public boolean isBusted() {
		return getHandScore() >= BUST_POINT;
	}
	
	public boolean isBlackJack() {
		return isBlackJack;
	}
	
	public boolean isTwentyOne() {
		return (getHandScore()==21 && !isBlackJack) ? true : false;
	}
	
	/**
	 * Defined to allow the sorting of a collection of Blackjack hands in greatest to
	 * least order.
	 */
	public int compareTo(BlackJackHand other) {
		if(score > other.score){
			return -1;
		}
		else if(score < other.score){
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public String printBlackJackHand() {
		String str = "(" + score + "): ";
		str += super.printHand();
		return str;
	}
	
	public boolean haveAce() {
		return hasAce;
	}
	
	/**
	 * Logic to calculate if we should draw another card based on current status of hand
	 * @return
	 */
	public boolean drawStatus() {
		if(!isBusted() && !isTwentyOne() && getHandScore() < 16) {
			return true;
		}
		else if(isBusted() && haveAce() && !allAcesAreReduced()) {
			return true;
		}
		else if(!isBusted() && !isTwentyOne() && haveAce() && !allAcesAreReduced() && getHandScore() < 17) {
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Determine if any Aces in the hand are still being used as value 11.
	 * @return
	 */
	private boolean allAcesAreReduced() {
			BlackJackCard card = null;
			for(Card el : cards) {
				card = (BlackJackCard) el;
				if(el.getValue()==11){
					return false;
				}
			}
			return true;
	}
	
	/**
	 * Modify assigned value of an ace card to 1.
	 */
	public void setAceToOne() {
		if(hasAce) {
			BlackJackCard card = null;
			for(Card el : cards) {
				card = (BlackJackCard) el;
				if(card.getValue()==11) {
					card.setAceToOne();
					break;
				}
			}
		}
	}
	

}
