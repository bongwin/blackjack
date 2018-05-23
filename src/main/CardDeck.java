package main;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {
	
	private Stack<Card> cards;
	private Card card;
	
	Pattern pattern;
	Symbol symbol;
	
	public CardDeck() {
		
		this.cards=generateCard();
		Collections.shuffle(this.cards);
	}

	private Stack<Card> generateCard() {
		cards = new Stack<Card>();
			for(Pattern pattern : pattern.values()) {
				for(Symbol symbol : symbol.values()) {
					Card card = new Card(pattern, symbol);
					cards.push(card);
				}
			}
		return cards;
	}
	
	 public Card Pick(){
		 return this.cards.pop();
	 }
	

}
