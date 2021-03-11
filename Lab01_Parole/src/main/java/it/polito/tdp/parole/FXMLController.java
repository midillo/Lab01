package it.polito.tdp.parole;

import it.polito.tdp.parole.model.ParoleLL;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	ParoleLL elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtPerformance;
    
    @FXML
    void doCancella(ActionEvent event) {
    	String parola = txtResult.getSelectedText();
    	double start = System.nanoTime();
    	elenco.removeParola(parola);
    	double end = System.nanoTime();
    	
    	txtResult.clear();
    	String result = "";
    	for(String s: elenco.getElenco()) {
    		result += s + "\n";
    	}
    	txtResult.setText(result);
    	
    	txtPerformance.clear();
    	txtPerformance.setText("Eseguito in: " + (end-start)/1000 + " microsecondi.");
      }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double start = System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	double end = System.nanoTime();
    	
    	txtResult.clear();
    	String result = "";
    	for(String s: elenco.getElenco()) {
    		result += s + "\n";
    	}
    	txtResult.setText(result);
    	
    	txtPerformance.clear();
    	txtPerformance.setText("Eseguito in: " + (end-start)/1000 + " microsecondi.");
    	txtParola.clear();
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.clear();
    	txtPerformance.clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"bntReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPerformance != null : "fx:id=\"txtPerformance\" was not injected: check your FXML file 'Scene.fxml'.";
       
        elenco = new ParoleLL() ;
    }
}
