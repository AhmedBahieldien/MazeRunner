/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import java.awt.Point;

/**
 *
 * @author dell-pc
 */
public class Originator {
    private Point playertile;

	// Sets the value for the article
	
	public void set(Point playertile) { 
		
	   this.playertile=playertile;
	}

	// Creates a new Memento with a new article
	
	public Memento storeInMemento() { 
	    
	    return new Memento(playertile); 
	}
	   
	// Gets the article currently stored in memento
	
	public Point restoreFromMemento(Memento memento) {
		   
		playertile= memento.getSavedArticle(); 
	       
		
		return playertile;
	   
	}
}
