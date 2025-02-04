package edu.smith.cs.csc212.spooky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This represents a place in our text adventure.
 * @author jfoley
 *
 */
public class Place {
	/**
	 * This is a list of places we can get to from this place.
	 */
	private List<Exit> exits;
	/**
	 * This is the identifier of the place.
	 */
	/**
	 * This is a list of the items in a location
	 */
	private List<String> items;
	
	private String id;
	/**
	 * What to tell the user about this place.
	 */
	private String description;
	/**
	 * Whether reaching this place ends the game.
	 */
	private boolean terminal;
	/**
	 * Whether the place has been previously visited.
	 */
	public boolean visited;
	/**
	 * description for counter 
	 */
	private int counter;
	
	
	/**
	 * Internal only constructor for Place. Use {@link #create(String, String)} or {@link #terminal(String, String)} instead.
	 * @param id - the internal id of this place.
	 * @param description - the user-facing description of the place.
	 * @param terminal - whether this place ends the game.
	 */
	protected Place(String id, String description, boolean terminal) {
		this.id = id;
		this.description = description;
		this.exits = new ArrayList<>();
		this.terminal = terminal;
		this.visited = false;
		this.counter = 0;
		this.items = new ArrayList<>();
	}
	
	/**
	 * Create an exit for the user to navigate to another Place.
	 * @param exit - the description and target of the other Place.
	 */
	public void addExit(Exit exit) {
		this.exits.add(exit);
	}
	
	/**
	 * For gameplay, whether this place ends the game.
	 * @return true if this is the end.
	 */
	public boolean isTerminalState() {
		return this.terminal;
	}
	
	/**
	 * The internal id of this place, for referring to it in {@link Exit} objects.
	 * @return the id.
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * The narrative description of this place.
	 * @return what we show to a player about this place.
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * making search method
	 */
	public void search() {
		for (Exit w: exits) {
			w.search();
		}
	}

	/**
	 * Get a view of the exits from this Place, for navigation.
	 * @return all the exits from this place.
	 */
	//change to return exits that are not secret.
	public List<Exit> getVisibleExits() {
		List<Exit> visible = new ArrayList<>();
		for (Exit e : this.exits) {
			if (!e.isSecret()) {
			visible.add(e);
			}
		}
		return visible;
	}
	//method that return list of items in a location
	public List<String> getItems() {
			return this.items;
		}
	
	//method that returns list of player items.
	//public List<String> getPlayerItems() {
	//	return this.pl
	//}
	
	
	/**
	 * This is a terminal location (good or bad).
	 * @param id - this is the id of the place (for creating {@link Exit} objects that go here).
	 * @param description - this is the description of the place.
	 * @return the Place object.
	 */
	public static Place terminal(String id, String description) {
		return new Place(id, description, true);
	}
	
	/**
	 * Create a place with an id and description.
	 * @param id - this is the id of the place (for creating {@link Exit} objects that go here).
	 * @param description - this is what we show to the user.
	 * @return the new Place object (add exits to it).
	 */
	public static Place create(String id, String description) {
		return new Place(id, description, false);
	}
	
	/**
	 * Implements what we need to put Place in a HashSet or HashMap.
	 */
	public int hashCode() {
		return this.id.hashCode();
	}
	
	/**
	 * Give a string for debugging what place is what.
	 */
	public String toString() {
		return "Place("+this.id+" with "+this.exits.size()+" exits.)";
	}
	
	/**
	 * Whether this is the same place as another.
	 */
	public boolean equals(Object other) {
		if (other instanceof Place) {
			return this.id.equals(((Place) other).id);
		}
		return false;
	}
	
	//update this flag from false to true in a visit() method
	public void visit() {
		//create a counter that tracks initial or subsequent visits
		counter += 1;
		if (counter >= 2) {
			this.visited = true;
		}
		
		
	}
	
	public void addItem(String item) {
		items.add(item);
	}
	
	public void removeItem(String item) {
		items.clear();
	}
	
	
	
	
	
}
