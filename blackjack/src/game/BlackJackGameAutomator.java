package game;

import game.GameDetails.GameType;

import java.util.ArrayList;
import java.util.Collections;

import cards.BlackJackHand;
import cards.Deck;
import cards.Hand;

public class BlackJackGameAutomator {
	
	private ArrayList<BlackJackHand> playerHands;
	private Deck deck;
	private ArrayList<Integer> blackJack = new ArrayList<>();
	protected GameType type = GameType.BLACKJACK;
	
	public BlackJackGameAutomator(int players) {
		deck = new Deck(1, type);
		playerHands = new ArrayList<>(players);
		for(int i = 0; i < players; i++) {
			BlackJackHand hand = (BlackJackHand) deck.dealHand();
			hand.setPlayer(String.valueOf(i));
			playerHands.add(hand);
			if(hand.isBlackJack()) {
				blackJack.add(i);
			}
		}
		System.out.println(printInitialResults());
		playAllHands();
		System.out.println(printFinalResults());
		System.out.println(deck.printDeck());
	}
	
	private void playHand(BlackJackHand hand) {
		hand.addCard(deck.dealCard());
	}
	
	private void playAllHands() {
		for(BlackJackHand hand : playerHands) {
			while(hand.drawStatus()){
				if(hand.haveAce() && hand.isBusted()) {
					hand.setAceToOne();
					continue;
				}
				playHand(hand);
			}
		}
	}
	
	/**
	 * Determines the winner(s) of the game.  Check for players who got BlackJack first,
	 * as they would be the winner(s).
	 * @return
	 */
	public String findWinners() {
		String winners = "Winner: ";
		int index = 0;
		if(!blackJack.isEmpty()) {
			for(Integer el : blackJack) {
				winners += el +",";
			}
			return winners;
		}
		Collections.sort(playerHands);
		int highest = 0;
		for(BlackJackHand hand : playerHands) {
			if(hand.getHandScore() >= highest && hand.getHandScore() <= 21) {
				winners += hand.getPlayer() + ", ";
				highest = hand.getHandScore();
			}
		}
		return winners;
	}
	
	/**
	 * Print final outcome of game
	 * @return
	 */
	public String printFinalResults() {
		StringBuilder results = new StringBuilder("-- Completed Game --\n");
		for(BlackJackHand hand : playerHands) {
			results.append("Hand " + hand.getPlayer() + " " + hand.printBlackJackHand()+"\n");
		}
		results.append("\n"+findWinners());
		return results.toString();
	}
	
	/**
	 * Print initial deal of cards to each player
	 * @return
	 */
	public String printInitialResults() {
		StringBuilder results = new StringBuilder("-- Initial --\n");
		for(BlackJackHand hand : playerHands) {
			results.append("Hand " + hand.getPlayer() + " " + hand.printBlackJackHand()+"\n");
		}
		return results.toString();
	}
}
