package cards;

import game.GameDetails.GameType;

import java.util.ArrayList;
import java.util.Random;

import cards.CardDetails.FaceValue;
import cards.CardDetails.Suit;

public class Deck {
	
	private ArrayList<Card> deck;
	private ArrayList<ArrayList<Card>> allDecks;
	private Random randomGenerator;
	private int cardsLeft;
	private final int DECK_SIZE;
	private GameType type;
	
	public Deck(int size, GameType type) {
		this.type = type;
		DECK_SIZE = size*52;
		cardsLeft = DECK_SIZE;
		allDecks = new ArrayList<>();
		deck = new ArrayList<>(DECK_SIZE);
		allDecks.add(deck);
		randomGenerator = new Random();
		for(Suit suit : Suit.values()){
			for(FaceValue value : FaceValue.values()){
				Card card;
				switch(type){
					case BLACKJACK: card = new BlackJackCard(value, suit);
									deck.add(card);
									break;
					default:		card = new Card(value, suit);
									deck.add(card);
				}
			}
		}
		shuffle();
	}
	
	/**
	 * Initial deal of two cards.  If the player count is too great a new deck can be created and 
	 * utilized to ensure the game can be finished.
	 * @return
	 */
	public Hand dealHand() {
		if(DECK_SIZE-cardsLeft >= deck.size()){
			System.out.println("Deck is empty.  Using additional deck.\n");
			Deck newDeck = new Deck(1, type);
			deck = newDeck.getDeck();
			allDecks.add(deck);
			cardsLeft = DECK_SIZE;
		}
		Card firstCard = deck.get(DECK_SIZE-cardsLeft--);
		firstCard.markUnavailable();
		Card secondCard = deck.get(DECK_SIZE-cardsLeft--);
		secondCard.markUnavailable();
		Hand hand;
		switch(type){
			case BLACKJACK: hand = new BlackJackHand(firstCard, secondCard);
							break;
			default:		hand = new Hand(firstCard, secondCard);
		
		}
		return hand;
	}
	
	/**
	 * Deal an additional card.  If deck runs out of cards a new deck will be created and
	 * utilized to ensure the game can be finished.
	 * @return
	 */
	public Card dealCard() {
		if(DECK_SIZE-cardsLeft >= deck.size()){
			System.out.println("Deck is empty.  Using additional deck.\n");
			Deck newDeck = new Deck(1, type);
			deck = newDeck.getDeck();
			allDecks.add(deck);
			cardsLeft = DECK_SIZE;
		}
		Card nextCard = deck.get(DECK_SIZE-cardsLeft--);
		nextCard.markUnavailable();
		return nextCard;
	}
	
	public String printDeck() {
		StringBuilder deckInformation = new StringBuilder("\n-- Deck Information --\n");
		int deckCount = 0;
		for(ArrayList<Card> deck : allDecks){
			deckInformation.append("Deck #" + ++deckCount + ":\n");
			for(Card el : deck) {
				deckInformation.append(el.printCardInformation() + " ");
			}
			deckInformation.append("\n");
		}
		return deckInformation.toString();
	}
	
	public void shuffle() {
		cardsLeft = DECK_SIZE;
		Card card = null;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < deck.size(); j++) {
				card = deck.remove(j);
				if(card.isCardAvailable()) {
					card.markAvailable();
				}
				deck.add(randomGenerator.nextInt(DECK_SIZE), card);
			}
		}
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
}
