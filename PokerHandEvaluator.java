package poker;

public class PokerHandEvaluator {

	private static int count(Card[] cards, int cardValue) { // Private method to reduce code dupication
		
		int count = 0;
		if (cardValue == cards[0].getValue()) { 
			count++;
		}
		if (cardValue == cards[1].getValue()) {
			count++;
		}
		if (cardValue == cards[2].getValue()) {
			count++;
		}
		if (cardValue == cards[3].getValue()) {
			count++;
		}
		if (cardValue == cards[4].getValue()) {
			count++;
		}
		return count;
	}

	private static boolean contains(Card[] cards, int number) { // Private Method to check Wrap-around case Straight
		
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getValue() == number) {
				return true;
			}
		}
		return false;

	}
	public static boolean hasPair(Card[] cards) { 

		for (int i = 0; i < cards.length; i++) { 
			if (count(cards, cards[i].getValue()) >= 2) {  // Checks every value 
				return true;
			}
		}
		return false;
	}

	public static boolean hasTwoPair(Card[] cards) {
		if((hasFourOfAKind(cards) == true)) {
			return false;
		}
		
		int count = 0;
		int[] count2 = new int[13];  // Card Values
		for (int i = 0; i < cards.length; i++) {
			count2[cards[i].getValue() - 1]++;
		}
		for (int i = 0; i < count2.length; i++) {
			if (count2[i] >= 2) {
				count++;
			}
			if (count >= 2) {
				return true;
			}

		}
		return false;

		// count2 [2, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0]
		// card -> [A, 5, 8, 8, A]
	}

	public static boolean hasThreeOfAKind(Card[] cards) {
		
		for (int i = 0; i < cards.length; i++) {
			if (count(cards, cards[i].getValue()) >= 3) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasStraight(Card[] cards) {
		
		int min = 14;

		if ((hasFourOfAKind(cards)) == true) {
			return false;
		}
		for (int i = 0; i < cards.length; i++) { // Find the minimum
			if (min >= cards[i].getValue()) { // //[A,2,3,4,5] or [10, J , Q, K , A]
				min = cards[i].getValue();
			}
		}		
		if (contains(cards, 1) && contains(cards, 10) && contains(cards,11) 
				&& contains(cards,12) && contains(cards,13)) {
			return true;
		}
		for (int i = min; i < min + 5; i++) {
			if (!contains(cards,i)) {
				return false;
			}
		}
		return true;
	}


	public static boolean hasFlush(Card[] cards) {
		
		int count = 0;
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getSuit() == cards[0].getSuit()) {
				count++;
			}
			if (cards[i].getSuit() == cards[1].getSuit()) {
				count++;
			}
			if (cards[i].getSuit() == cards[2].getSuit()) {
				count++;
			}
			if (cards[i].getSuit() == cards[3].getSuit()) {
				count++;
			}
			if (cards[i].getSuit() == cards[4].getSuit()) {
				count++;
			}
			if (count < 5) {
				count = 0;
			}

		}
		if (count >= 5) {
			return true;
		}
		return false;

	}

	public static boolean hasFullHouse(Card[] cards) {
		
		if ((hasThreeOfAKind(cards) == true) && hasTwoPair(cards) == true) {
			return true;
		}
		
		return false;
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		
		for (int i = 0; i < cards.length; i++) {
			if (count(cards, cards[i].getValue()) >= 4) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasStraightFlush(Card[] cards) {

		if ((hasFlush(cards) == true) && (hasStraight(cards)) == true) {
			return true;
		}
		return false;
	}

}
