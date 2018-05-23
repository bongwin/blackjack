package main;

import java.util.Stack;

public class Player implements User{
	
	private Stack<Card> cards;
	private boolean turn;
	private String name;
//	private int TotalPointOfCard;
	
	public Player() {
		 this.cards = new Stack<Card>();
		 this.name= getName();
	}

	@Override
	public String getName() {
		return "플레이어1";
	}

	@Override
	public Stack<Card> receiveCard(Card card) {
		 this.cards.push(card);
		 this.checkCard();
		 return this.cards;		 
	}

	@Override
	public void checkCard() {
		StringBuilder sb = new StringBuilder();
		 sb.append("현재 보유 카드 목록 \n");
		 
		 for(Card card : cards){
			 sb.append(card.toString());
			 sb.append("\n");
		 }
		 System.out.println(sb.toString());
	}

	@Override
	public void takeTurn() {
		this.setTurn(true);		
	}

	@Override
	public void giveUpTurn() {
		this.setTurn(false);		
	}

	@Override
	public void setTurn(boolean turn) {
		this.turn = turn;		
	}

	@Override
	public boolean doTurn() {
		return this.turn;
	}

	@Override
	public Stack<Card> openCards() {
		return this.cards;
	}

}
