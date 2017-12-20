package com.ag.brain;

import com.ag.brain.Block;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ArrayList;

public class BlockChain {

	private List<Block> chain = new ArrayList<Block>();
	private int nonce;

	public BlockChain(){
		Block gen = new Block("Hey you, I'm a Computer! Stop all your downloading!");
		// createNewHash(gen);
	}

	public boolean isValidHash(String prevHash){
		char[] c = {prevHash.charAt(0),prevHash.charAt(1),prevHash.charAt(2),prevHash.charAt(3)};
		for(char i : c){
			if (i != '0') {
				return false;
							}
		}
		return true;
	}

	public void addNewBlock(Block b){
		System.out.println(getNonce());
	}

	public void addToChain(Block b){
		chain.add(b);
	}

	/*public void createNewHash(Block b){
		try{
			MessageDigest digst = MessageDigest.getInstance("SHA-256");
			String s = b.getData()+b.getDate()+String.valueOf(b.getIndex())+b.getPreviousHash();
			byte[] hashbytes = digst.digest(s.getBytes("UTF-8"));
			StringBuffer sBuff = new StringBuffer();
			for (int i = 0;i<hashbytes.length; i++) {
				sBuff.append(Integer.toString((hashbytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			String newHash = sBuff.toString();
			if(!isValidHash(newHash)){
				nonce++;
				createNewHash(newHash);
			}

		}catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}

	}*/

	public int getNonce(){
		return nonce;
	}

	public String toString(){
		String res = "[ ";
		for (Block b : chain) {
			res += b.getPreviousHash() + ", \n";
		}
		res += " ]";
		return res;
	}


}