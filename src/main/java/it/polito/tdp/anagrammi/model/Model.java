package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.dao.AnagrammaDAO;

public class Model {
	
	AnagrammaDAO dao = new AnagrammaDAO();
	
	public Set<String> anagramma(String s) {
		Set<String> anagrammi = new HashSet<String>();
		ricorsione_anagramma("",0,s,anagrammi);
		return anagrammi;
	}

	private void ricorsione_anagramma(String anagramma, int livello, String rimanenti,Set<String> anagrammi) {
		if(rimanenti.length()==0) {
			anagrammi.add(anagramma);
			//System.out.println(anagramma);
			return;
		}
		else {
			for(int pos=0; pos<rimanenti.length();pos++) {
				String nuovo_anagramma= anagramma+rimanenti.charAt(pos);
				String nuova_rimanenza= rimanenti.substring(0, pos)+rimanenti.substring(pos+1);
				ricorsione_anagramma(nuovo_anagramma,livello+1,nuova_rimanenza,anagrammi);
			}
		}
		
	}
	
	public boolean isCorrect(String anagramma) {
		return this.dao.isCorrect(anagramma);
	}
	
}
