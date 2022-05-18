/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model= new Model();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnagrammi"
    private Button btnAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtSbagliati"
    private TextArea txtSbagliati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doAnagrammi(ActionEvent event) {
    	txtCorretti.clear();
    	txtSbagliati.clear();
    	String daCercare = txtParola.getText();
    	if(daCercare.length()==0) {
    		txtCorretti.setText("Scrivere una parola da anagrammare");
    		return;
    	}
    	if(daCercare.length()<2) {
    		txtCorretti.setText("Parola monolettera:non angrammabile");
    		return;
    	}
    	if(daCercare.length()>8) {
    		txtCorretti.setText("Parola troppo lunga");
    		return;
    	}
    	Set<String> anagrammi = model.anagramma(daCercare);
    	for(String s : anagrammi) {
    		if(this.model.isCorrect(s))
    			txtCorretti.appendText(s +" \n");
    	    else 
    	    	txtSbagliati.appendText(s + "\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretti.clear();
    	txtSbagliati.clear();

    }
    public void setModel(Model model) {
    	this.model= model;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSbagliati != null : "fx:id=\"txtSbagliati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
