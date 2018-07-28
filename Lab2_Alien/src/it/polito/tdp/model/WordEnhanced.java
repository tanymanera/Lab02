package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {

	private String alienWord;
	private List<String> translations;
	
	public WordEnhanced(String alienWord, String translation) {
		super();
		translations = new ArrayList<String>();
		this.alienWord = alienWord;
		this.translations.add(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public List<String> getTranslations() {
		return translations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WordEnhanced)) {
			return false;
		}
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null) {
				return false;
			}
		} else if (!alienWord.equals(other.alienWord)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "WordEnhanced [alienWord=" + alienWord + ", translations=" + translations + "]";
	}

	public boolean compareWild(String alienWild) {
		if( alienWord.matches(alienWild)){
			return true;
		}
		return false;
	}
	
	
}
