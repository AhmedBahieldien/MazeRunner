
package mazerunner;

import java.awt.Point;


public class Memento {
    // The article stored in memento Object
	
	private Point playertile;

	// Save a new article String to the memento Object
	
	public Memento(Point playertile) { this.playertile =playertile; }
	
	// Return the value stored in article 
	
	public Point getSavedArticle() { return playertile; }
    
    
    
}
