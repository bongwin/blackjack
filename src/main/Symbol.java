package main;

public enum Symbol {

	ACE("a",1),
	TWO("2",2),
	THREE("3",3),
	FOUR("4",4),
	FIVE("5",5),
	SIX("6",6),
	SEVEN("7",7),
	EIGHT("8",8),
	NINE("9",9),
	TEN("10",10),
	JUMP("J",10),
	QUEEN("Q",10),
	KING("K",10);
	
	String mark = null;
	int point = 0;
	
	Symbol(String mark, int point){
		this.mark = mark;
		this.point = point;
	}
	
	int getPoint() {
		return this.point;
	}
}
