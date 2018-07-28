package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<WordEnhanced> dizionario;

	public AlienDictionary() {
		dizionario = new ArrayList<WordEnhanced>();
	}

	public void addWord(String alienWord, String translation) {
		WordEnhanced word = new WordEnhanced(alienWord, translation);
		if (!dizionario.contains(word)) {
			dizionario.add(word);
		} else {
			for (WordEnhanced w : dizionario) {
				List<String> traduzioni = w.getTranslations();
				if (w.equals(new WordEnhanced(alienWord, null)) && !traduzioni.contains(translation)) {
					traduzioni.add(translation);
					return;
				}
			}
		}
	}

	public String translateWord(String alienWord) {
		WordEnhanced wordSearched = new WordEnhanced(alienWord, null);
		if (dizionario.contains(wordSearched)) {
			for (WordEnhanced w : dizionario) {
				if (w.equals(wordSearched)) {
					return w.getTranslations().toString();
				}
			}
		}
		return null;
	}
	
	public String translateWordWithWildcard(String alienWord) {
		StringBuilder result = new StringBuilder("\n");
		alienWord = alienWord.replaceAll("\\?", ".");
		
		for(WordEnhanced we: dizionario) {
			if(we.compareWild(alienWord)) {
				result.append(we.getAlienWord() + " si traduce come " + we.getTranslations().toString() + "\n");
			}
		}
		String resultStr = result.toString();
		if(resultStr.equals("\n")) {
			return null;
		}
		
		return resultStr;
	}
	

	public int getSize() {
		int dimensione = 0;
		for (WordEnhanced we : dizionario) {
			dimensione += we.getTranslations().size();
		}
		return dimensione;
	}

}
