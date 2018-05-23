package main;

public enum Pattern {
	
	SPADE("spade"),
	HEART("heart"),
	DIAMOND("diamond"),
	CLOVER("clover");
	
	String value=null;
	
	Pattern(String value){
		this.value=value;
	}
	

}
