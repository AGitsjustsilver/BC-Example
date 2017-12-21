package com.ag.main;

import com.ag.brain.*;

public class Main {

	public static Block gen;
	public static Block b1;
	public static Block b2;
	public static Block b3;
	
	public static void main(String [] args){
		BlockChain b = new BlockChain();
		gen = new Block("Hey you, I'm a Computer! Stop all your downloading!");
		b1 = new Block("knock knock.", 01, gen.getNewHash());		
		// b2 = new Block("Hi I am data", 02, b1.getNewHash());
		// b3 = new Block("Hi data im block", 03, b2.getNewHash());
		b.addNewBlock(gen);
		b.addNewBlock(b1);
		// b.addNewBlock(b2);
		// b.addNewBlock(b3);
		System.out.println(b);
	}

}