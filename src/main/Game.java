package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Game {

	Stack<Card> cards;
	ArrayList<User> users;
	CardDeck cardDeck;
	Scanner sc;
	User user;
	
	public void play() {
		users = userCount(); 
		cardDeck = new CardDeck(); 
		sc = new Scanner(System.in);
		
		System.out.println("---BlackJack Start---");
		
		this.cards = initGame(users, cardDeck);	
		this.cards = playGame(sc, users, cardDeck);
		
		Rule rule = new Rule();  
		this.user =rule.selectWinner(users);  
		System.out.println("승자는\n"+this.user.getName()+"입니다");  
	}

	private Stack<Card> playGame(Scanner sc, ArrayList<User> users, CardDeck cardDeck) {
		while (true) {
			this.cards = OnePairTurn(sc, users, cardDeck, cards);
			if (AllUserGiveUpTurn(users)) {	
				break;
			}
		}
		return this.cards;
	}

	private boolean AllUserGiveUpTurn(ArrayList<User> users) {
		for (User user : users) {
			if (user.doTurn()) {
				return false;
			}
		}
		return true;
	}

	private Stack<Card> OnePairTurn(Scanner sc, ArrayList<User> users, CardDeck cardDeck, Stack<Card> cards) {
		for (User user : users) {
			System.out.println(user.getName() + "님 차례입니다");
			System.out.println("카드를 뽑아주세요. 안 뽑는다면 0번을 눌러주세요");
			int num = sc.nextInt();
			
			if (num == 0) {
				user.giveUpTurn(); 
				
			}else if (num != 0) {
				Card card = cardDeck.Pick();
				cards = user.receiveCard(card);
				user.takeTurn(); 
			}
		}
		return cards;
	}

	private Stack<Card> initGame(ArrayList<User> users, CardDeck cardDeck) {
		this.cards = new Stack<Card>();
		
		for (int i = 0; i < 2; i++) {
			for (User user : users) {
				System.out.println(user.getName() + "님 차례입니다");
				Card card = cardDeck.Pick();
				this.cards = user.receiveCard(card);
			}
		}
		return this.cards;
	}

	private ArrayList<User> userCount() {
		ArrayList<User> user = new ArrayList<User>();
		user.add(new Dealer());
		user.add(new Player());
		
		return user;
	}

}
