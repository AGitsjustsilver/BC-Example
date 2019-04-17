package com.ag.brain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block{

	private Date date;
	private int index;
	private int nonce;
	private String data;
	private String nuHash;
	private String prevHash;


	public Block(String data){//genesis block
		index = 0;
		date = new Date();
		this.data = data;
		prevHash = "";
		nuHash = createNewHash(prevHash);
	}

	public Block(String data, int ind, String preHash){//blocks after genesis
		date = new Date();
		this.data = data;
		index = ind;
		prevHash = preHash;
		nuHash = createNewHash(prevHash);
	}

	public String createNewHash(String preHash){
		try{
			MessageDigest digst = MessageDigest.getInstance("SHA-256");
			String s = getData() + getDate() + String.valueOf(getIndex()) + preHash;
			byte[] hashbytes = digst.digest(s.getBytes("UTF-8"));
			StringBuffer sBuff = new StringBuffer();
			for (int i = 0;i<hashbytes.length; i++) {
				sBuff.append(Integer.toString((hashbytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			String newHash = sBuff.toString();
			while(!isValidHash(newHash)){
				nonce++;
				createNewHash(newHash);
			}
			return newHash;
		}catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			System.out.println(e);
		}
		return "";
	}

	public boolean isValidHash(String pHash){
		char[] c = {pHash.charAt(0)/*,pHash.charAt(1),pHash.charAt(2),pHash.charAt(3)*/};
		for(char i : c){
			if (i != '0') {
				return false;
			}
		}
		return true;
	}


	//accessors
	public String getDate(){
		return date.toString();
	} 

	public int getIndex(){
		return index;
	}

	public int getNonce(){
		return nonce;
	}

	public String getData(){
		return data;
	}

	public String getNewHash(){
		return nuHash;
	}

	public String getPreviousHash(){
		return prevHash;
	}

}