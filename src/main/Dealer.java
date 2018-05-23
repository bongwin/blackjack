package main;

import java.util.Stack;

public class Dealer implements User {
	
	private Stack<Card> cards;
	private boolean turn;
	private String name;
	private int TotalPointOfCard;
	
	public Dealer() {
		cards = new Stack<Card>();
		this.name= getName();
	}

	@Override
	public String getName() {
		return "딜러";
	}

	@Override
	public Stack<Card> receiveCard(Card card) {
		if(TotalPointOfCard()>16){
			System.out.println("딜러 점수 : "+ TotalPointOfCard());
			System.out.println("17점 이상이므로 카드를 받을 수 없습니다.");
			
		}else {
			this.cards.push(card);
			this.checkCard();
		}
		return this.cards;
	}
	
	private int TotalPointOfCard() {
		for(Card card : cards){
			TotalPointOfCard+=card.symbol.getPoint();
		}
		return TotalPointOfCard;
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
