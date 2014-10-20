package cards;

import java.util.ArrayList;

public class Hand {
	
	protected ArrayList<Card> cards;
	private String player;
	
	public Hand(Card firstCard, Card secondCard) {
		cards = new ArrayList<>();
		cards.add(firstCard);
		cards.add(secondCard);
	}
	
	public void addCard(Card newCard) {
		cards.add(newCard);
	}
	
	public String printHand() {
		String hand = "";
		for(Card el: cards){
			hand += el.printCardInformation() + " ";
		}
		return hand;
	}
	
	public void setPlayer(String player) {
		this.player = player;
	}
	
	public String getPlayer() {
		return player;
	}

}
