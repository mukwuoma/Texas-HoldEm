package poker;

import java.util.Arrays;

public class Deck {

	private Card[] cards;

	public Deck() {

		this.cards = new Card[52]; // Initialize Deck
		int index = 0; // Initialize index for array
		for (int suit = 0; suit < 4; suit++) { // First for loop for suit
			for (int value = 1; value <= 13; value++) { // Second for loop for rank of cards
				cards[index++] = new Card(value, suit);
			} // 0,1, 0,2, 0,3 ... , 0,13 ,1,1, ... 1,13, 2,13 .. 3,13
		}
	}

	public Deck(Deck other) {

		this.cards = other.cards;
	}

	public Card getCardAt(int position) {

		return cards[position];

	}

	public int getNumCards() {

		return cards.length;

	}

	public void shuffle() {

		Card[] topHalf = new Card[cards.length / 2]; // Make a new Array for the top half
		Card[] bottomHalf = new Card[cards.length / 2]; // Make a new Array for the bottom half
		int x = 0;
		int y = 0;

		if ((cards.length) % 2 != 0) { // Check if the deck length is odd
			topHalf = new Card[topHalf.length + 1]; // If it is odd take one number from bottom half
		}

		for (int i = 0; i < topHalf.length; i++) { // Copy first half of cards into new Array(length is longer)
			topHalf[x++] = cards[i]; // counter for increment index in the topHalf and transferring cards to new
										// Array
		}

		for (int j = topHalf.length; j < cards.length; j++) { // Copy remaining cards into bottom half of array
			bottomHalf[y++] = cards[j];
		} // checking card was even or odd
		x = 0; // Reinitialize variable
		y = 0;
		for (int m = 0; m < cards.length; m++) { // for loop to access array
			if ((m % 2) == 0) { // checking if "m" is odd or even
				cards[m] = topHalf[x++]; // if m is even store in topHalf (A of S, A of C , 2 of C)
			} else {
				cards[m] = bottomHalf[y++]; // store remaining cards in available elements
			}
		}

	}

	public void cut(int position) {

		Card[] topHalf = new Card[position]; // Top Half length is the number of positions
		Card[] bottomHalf = new Card[cards.length - position]; // bottomHalf length is remaining cards
		int index = 0;
		int index2 = position; // Index starts at position after topHalf is cut

		for (int i = 0; i < topHalf.length; i++) { // copy cards to topHlf array
			topHalf[i] = cards[i];
		}
		for (int j = 0; j < bottomHalf.length; j++) { // Copy remaining cards from uncut cards to bottomHalf
			bottomHalf[j] = cards[index2++]; // Copy bottomHalf into index starting from position
		}
		for (int k = 0; k < cards.length; k++) { // Begin to move BottomHalf
			if (k < bottomHalf.length) { // store bottomHald cards starting at index 0 back into cards
				cards[k] = bottomHalf[k]; // until it reaches the bottom half length
			} else {
				cards[k] = topHalf[index++]; // store topHalf in cards after bottomHalf
			}
		}

	}

	public Card[] deal(int numCards) {

		Card[] smaller = new Card[cards.length - numCards]; // Create new array without dealt cards

		Card[] dealtCards = new Card[numCards]; // Create new array with dealt cards
		for (int i = 0; i < numCards; i++) {
			dealtCards[i] = cards[i]; // Copy cards into new Array
		}
		for (int k = 0; k < smaller.length; k++) { // create new array to store
			smaller[k] = cards[k + numCards]; // // add numOfCards to access every element in array
		}
		cards = new Card[smaller.length]; // make new card object with smaller length
		for (int j = 0; j < smaller.length; j++) {
			this.cards[j] = smaller[j];
		}
		return dealtCards;
	}

	public String toString() {
		return Arrays.toString(cards);

	}

}
