/**
 * LINKEDLIST CI METTE MOLTO PIU' TEMPO RISPETTO A ARRAYLIST
 */

package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ParoleLL {
		
	List<String> parole;
	
	public ParoleLL() {
		parole = new LinkedList<>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public void removeParola(String p) {
		parole.remove(p);
	}

}
