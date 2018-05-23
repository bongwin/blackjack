package main;

public class Card {
	
	Pattern pattern;
	Symbol symbol;
	
	public Card(Pattern pattern, Symbol symbol) {
		this.pattern = pattern;
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return "[pattern=" + pattern + ", symbol=" + symbol + "]";
	}
	
	
	

}
