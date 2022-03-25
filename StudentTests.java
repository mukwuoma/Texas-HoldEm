package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	@Test
	public void test() {

		Deck deck = new Deck();
		deck.deal(5);
	}

	@Test
	public void hasPairTest1() {

		Card[] card = { new Card(1, 1), new Card(1, 1), new Card(13, 1), new Card(11, 3), new Card(5, 2) };
		assertTrue(PokerHandEvaluator.hasPair(card)); // done
	}

	@Test
	public void hasPairTest2() {

		Card[] card = { new Card(2, 2), new Card(2, 1), new Card(13, 3), new Card(1, 3), new Card(2, 2) };
		assertTrue(PokerHandEvaluator.hasPair(card)); // done
	}

	@Test(expected = RuntimeException.class)
	public void hasPairTest3() {

		Card[] card = { new Card(5, 2), new Card(2, 13), new Card(13, 3), new Card(1, 3), new Card(2, 2) };
		assertTrue(PokerHandEvaluator.hasPair(card)); // done

	}

	@Test
	public void hasPairTest4() {

		Card[] card = { new Card(1, 1), new Card(1, 3), new Card(1, 0), new Card(10, 2), new Card(10, 3) };
		assertTrue(PokerHandEvaluator.hasPair(card));
	}

	@Test
	public void hasTwoPair1() {

		Card[] card = { new Card(4, 2), new Card(4, 1), new Card(6, 0), new Card(6, 3), new Card(4, 2) };
		assertTrue(PokerHandEvaluator.hasTwoPair(card));
	}

	@Test
	public void hasTwoPair2() {

		Card[] card = { new Card(2, 3), new Card(2, 2), new Card(13, 3), new Card(13, 1), new Card(1, 3) };
		assertTrue(PokerHandEvaluator.hasTwoPair(card));
	}

	@Test
	public void hasTwoPair3() {

		Card[] card = { new Card(10, 2), new Card(10, 3), new Card(5, 3), new Card(5, 2), new Card(5, 0) };
		assertTrue(PokerHandEvaluator.hasTwoPair(card));

	}

	@Test
	public void hasTwoPair4() {
		Card[] card = { new Card(9, 2), new Card(7, 3), new Card(7, 3), new Card(1, 0), new Card(8, 2) };
		assertFalse(PokerHandEvaluator.hasTwoPair(card));
	}

	@Test
	public void hasThreeOfAKind1() {

		Card[] card = { new Card(9, 2), new Card(2, 3), new Card(5, 3), new Card(9, 3), new Card(9, 0) };
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(card)); // done
	}

	@Test
	public void hasThreeOfAKind2() {
		Card[] card = { new Card(9, 1), new Card(8, 0), new Card(2, 2), new Card(10, 3), new Card(13, 0) };
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(card)); // done
	}

	@Test
	public void hasThreeOfAKind() {

		Card[] card = { new Card(1, 1), new Card(1, 3), new Card(1, 0), new Card(10, 2), new Card(10, 3) };

		assertTrue(PokerHandEvaluator.hasThreeOfAKind(card));
	}

	@Test
	public void hasStraight1() {

		Card[] card = { new Card(9, 2), new Card(9, 2), new Card(9, 2), new Card(9, 3), new Card(9, 0) };
		assertFalse(PokerHandEvaluator.hasStraight(card));
	}

	@Test
	public void hasStraight2() {

		Card[] card = { new Card(9, 2), new Card(9, 2), new Card(9, 2), new Card(9, 2), new Card(9, 2) };
		assertFalse(PokerHandEvaluator.hasStraight(card));

	}

	@Test
	public void hasStraight3() {

		Card[] card = { new Card(4, 3), new Card(1, 3), new Card(2, 3), new Card(3, 3), new Card(5, 3) };
		assertTrue(PokerHandEvaluator.hasStraight(card));
	}

	@Test
	public void hasStraight4() {

		Card[] card = { new Card(13, 2), new Card(12, 2), new Card(11, 2), new Card(10, 3), new Card(1, 0) };
		assertTrue(PokerHandEvaluator.hasStraight(card));
	}

	@Test
	public void hasStraight5() {

		Card[] card = { new Card(5, 3), new Card(4, 2), new Card(3, 2), new Card(2, 1), new Card(6, 0) };
		assertTrue(PokerHandEvaluator.hasStraight(card));

	}

	@Test
	public void hasFlush1() {

		Card[] card = { new Card(13, 2), new Card(12, 2), new Card(11, 2), new Card(10, 2), new Card(9, 2) };
		assertTrue(PokerHandEvaluator.hasFlush(card)); // done
	}

	@Test
	public void hasFlush2() {

		Card[] card = { new Card(13, 3), new Card(13, 3), new Card(13, 3), new Card(12, 3), new Card(12, 3) };
		assertTrue(PokerHandEvaluator.hasFlush(card)); // done
	}

	@Test
	public void hasFlush3() {

		Card[] card = { new Card(8, 1), new Card(8, 1), new Card(8, 2), new Card(8, 1), new Card(8, 1) };
		assertFalse(PokerHandEvaluator.hasFlush(card)); // done
	}

	@Test
	public void hasFlush4() {

		Card[] card = { new Card(1, 1), new Card(1, 1), new Card(13, 1), new Card(11, 3), new Card(5, 2) };
		assertFalse(PokerHandEvaluator.hasFlush(card));
	}

	@Test
	public void hasFullHouse1() {

		Card[] card = { new Card(9, 0), new Card(8, 3), new Card(1, 2), new Card(4, 3), new Card(5, 1) };
		assertFalse(PokerHandEvaluator.hasFullHouse(card));
	}

	@Test
	public void hasFullHouse2() {

		Card[] card = { new Card(9, 3), new Card(9, 3), new Card(9, 2), new Card(3, 3), new Card(8, 1) };
		assertFalse(PokerHandEvaluator.hasFullHouse(card));
	}

	@Test
	public void hasFullHouse3() {

		Card[] card = { new Card(3, 2), new Card(3, 2), new Card(7, 2), new Card(2, 3), new Card(2, 1) };
		assertFalse(PokerHandEvaluator.hasFullHouse(card));

	}

	@Test
	public void hasFullHouse4() {

		Card[] card = { new Card(1, 1), new Card(1, 1), new Card(1, 1), new Card(13, 3), new Card(13, 2) };
		assertTrue(PokerHandEvaluator.hasFullHouse(card));
	}

	@Test
	public void hasFourOfAKind1() {

		Card[] card = { new Card(11, 3), new Card(7, 3), new Card(11, 2), new Card(11, 2), new Card(11, 0) };
		assertTrue(PokerHandEvaluator.hasFourOfAKind(card)); // done
	}

	@Test
	public void hasFourOfAKind2() {
		Card[] card = { new Card(11, 2), new Card(11, 2), new Card(12, 2), new Card(11, 2), new Card(13, 2) };
		assertFalse(PokerHandEvaluator.hasFourOfAKind(card)); // done

	}

	@Test
	public void hasFourOfAKind3() {
		Card[] card = { new Card(1, 1), new Card(1, 1), new Card(13, 1), new Card(11, 3), new Card(5, 2) };
		assertFalse(PokerHandEvaluator.hasFourOfAKind(card));
	}

	@Test
	public void hasStraightFlush1() {
		Card[] card = { new Card(1, 3), new Card(2, 3), new Card(3, 3), new Card(4, 3), new Card(5, 3) };
		assertTrue(PokerHandEvaluator.hasStraightFlush(card));
	}
	@Test
	public void hasStraightFlush2() {
		Card[] card = {new Card(1, 3), new Card(10, 3), new Card(11, 3), new Card(13, 3), new Card(12, 3) };
		assertTrue(PokerHandEvaluator.hasStraightFlush(card));
	}
	@Test
	public void hasStraightFlush3() {
		Card [] card = {new Card(1, 3), new Card(11, 3), new Card(12, 3), new Card(13, 3), new Card(2, 3) };
		assertFalse(PokerHandEvaluator.hasStraightFlush(card));
	}

	@Test
	public void dealTest() {
		Deck deck = new Deck();
		deck.deal(51);
	}

	@Test
	public void shuffleTest1() {
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println(deck);
	}

	@Test
	public void Cut1() {
		Deck deck = new Deck();
		deck.deal(6);
		System.out.println(deck);
	}
}