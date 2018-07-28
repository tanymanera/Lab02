package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.model.AlienDictionary;
import it.polito.tdp.model.WordEnhanced;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

	private AlienDictionary model;

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField txtWord;
	@FXML
	private TextArea txtResult;
	@FXML
	private Button btnTranslate;
	@FXML
	private Button btnReset;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

	}

	@FXML
	void doTranslate(ActionEvent event) {
		txtResult.clear();
		String riga = txtWord.getText().toLowerCase();
		if (!riga.matches("[a-z ?]*")) {
			txtResult.appendText("Inserire solo caratteri alfabetici e una wild card '?'.");
			return;
		}

		if (riga == null || riga.length() == 0) {
			txtResult.appendText("Perfavore inserire una o due parole. (<parola aliena> <traduzione>)\n");
			return;
		}

		StringTokenizer stringTokenizer = new StringTokenizer(riga, " ");

		// primo token è la parola aliena
		String alienWord = stringTokenizer.nextToken();
		// System.out.println(alienWord);
		if (!stringTokenizer.hasMoreTokens()) {
			String translation;
			if (alienWord.contains("?")) {
				translation = model.translateWordWithWildcard(alienWord);
			} else {
				translation = model.translateWord(alienWord);
			}
			if (translation != null) {
				txtResult.appendText("La traduzione di " + alienWord + " è: " + translation);
			} else {
				txtResult.appendText("Parola non presente.\n");
			}
			return;

		}
		String traduzione = stringTokenizer.nextToken();
		int size = model.getSize();
		model.addWord(alienWord, traduzione);
		if (model.getSize() > size) {
			txtResult.appendText("Parola inserita");
		} else {
			txtResult.appendText("Parola già presente e quindi non inserita\n");
		}
		// Esiste una o più parole dopo la seconda
		if (stringTokenizer.hasMoreElements()) {
			txtResult.appendText("Inserire al massimo due parole.\n");
		}
	}

	@FXML
	void doReset(ActionEvent event) {

		txtWord.clear();
		txtResult.clear();
	}

	public void setModel(AlienDictionary model) {
		this.model = model;
	}

}
