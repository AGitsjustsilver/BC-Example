package com.ag.brain;

import com.ag.brain.Block;

import java.util.List;
import java.util.ArrayList;

public class BlockChain {

	private List<Block> chain = new ArrayList<Block>();
	public BlockChain(){
	}

	public void addNewBlock(Block b){
		System.out.println(b.getNonce());
		addToChain(b);
	}

	public void addToChain(Block b){
		chain.add(b);
	}

	public String toString(){
		String res = "[ ";
		for (Block b : chain) {
			res += b.getNewHash() + " , \n";
		}
		res += " ]";
		return res;
	}


}