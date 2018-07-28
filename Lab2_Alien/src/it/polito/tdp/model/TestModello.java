package it.polito.tdp.model;

public class TestModello {

	public static void main(String[] args) {
		AlienDictionary ad = new AlienDictionary();
		ad.addWord("Klatu", "Klatu");
		ad.addWord("varada", "chiede");
		ad.addWord("varada", "xxx");
		ad.addWord("nictor", "aiuto");
		ad.addWord("Klatu", "Pippo");
		ad.addWord("varada", "xxx");
		
		System.out.println("varada voul dire " + ad.translateWord("varada"));
		System.out.println("Klatu vuol dire " + ad.translateWord("Klatu"));
		
	}

}
