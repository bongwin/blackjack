package main;

import java.util.Stack;

public interface User {
	
	String getName();
	Stack<Card> receiveCard(Card card); 
	void checkCard();
	void takeTurn();
	void giveUpTurn();
	void setTurn(boolean turn);
	boolean doTurn();
	Stack<Card> openCards();   
}
