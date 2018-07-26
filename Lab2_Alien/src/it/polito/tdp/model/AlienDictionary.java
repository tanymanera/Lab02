package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> dizionario;

	public AlienDictionary() {
		dizionario = new ArrayList<Word>();
	}
	
	public void addWord(String alienWord, String translation) {
		Word word = new Word(alienWord, translation);
		if(!dizionario.contains(word)) {
			dizionario.add(word);
		}
	}
	
	public String translateWord(String alienWord) {
		Word wordSearched = new Word(alienWord, null);
		if(dizionario.contains(wordSearched)) {
			for(Word w: dizionario) {
				if(w.equals(wordSearched)) {
					return w.getTranslation();
				}
			}
		}
		return null;
	}
	
	public int getSize() {
		return dizionario.size();
	}

}
