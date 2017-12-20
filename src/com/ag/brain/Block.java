package com.ag.brain;

import java.util.Date;

public class Block{

	private Date date;
	private int index;
	private String data;
	private String prevHash;


	public Block(String data){//genesis block
		index = 0;
		date = new Date();
		this.data = data;
		prevHash = "";
	}

	public Block(String data, int ind, String preHash){//blocks after genesis
		date = new Date();
		this.data = data;
		index = ind;
		prevHash = preHash;
	}

	//accessors
	public String getDate(){
		return date.toString();
	} 

	public int getIndex(){
		return index;
	}

	public String getData(){
		return data;
	}

	public String getPreviousHash(){
		return prevHash;
	}


}