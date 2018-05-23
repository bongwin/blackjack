package main;

import java.util.ArrayList;
import java.util.Stack;

public class Rule {

	Card card;
	User highestUser = null;
	int highestPoint=0;
	int totalPoint=0;
	
	public User selectWinner(ArrayList<User> users) {
		for(User user: users){		
			totalPoint = getTotalPoint(user.openCards());
			if(totalPoint > highestPoint){
				this.highestUser=user;
				this.highestPoint=totalPoint;
			}
		}
		return this.highestUser;
	}
	
	private int getTotalPoint(Stack<Card> openCards) {
		for(Card card : openCards){
			totalPoint+=card.symbol.getPoint();
		}
		return totalPoint;
	}
}
