package cards;

/**
 * A class to hold all enumerated types for a card
 * @author Jared
 *
 */
public class CardDetails {
	public static enum FaceValue {
		TWO ("2"), THREE ("3"), FOUR ("4"), FIVE ("5"), SIX ("6"), SEVEN ("7"), 
		EIGHT ("8"), NINE ("9"),TEN ("10"), JACK ("J"), QUEEN ("Q"), KING ("K"), ACE ("A");
		
		private final String type;
		
		private FaceValue(String str) {
			this.type = str;
		}
		
		public String getValue() {
			return type;
		}
		
	}
	
	public static enum Suit {
		CLUBS ("c"), HEARTS ("h"), DIAMONDS ("d"), SPADES ("s");
		
		private final String suit;
		
		private Suit(String suit) {
			this.suit = suit;
		}
		
		public String getSuit() {
			return suit;
		}
	}
}
