package edu.smith.cs.csc212.spooky;

import java.util.ArrayList;
import java.util.List;

/**
 * This is our main class for SpookyMansion.
 * It interacts with a GameWorld and handles user-input.
 * It can play any game, really.
 *
 * @author jfoley
 *
 */
public class InteractiveFiction {

	/**
	 * This method actually plays the game.
	 * @param input - a helper object to ask the user questions.
	 * @param game - the places and exits that make up the game we're playing.
	 * @return where - the place the player finished.
	 */
	static String runGame(TextInput input, GameWorld game) {
		// This is the current location of the player (initialize as start).
		// Maybe we'll expand this to a Player object.
		String place = game.getStart();
		List<String> playerItems = new ArrayList<>();
		

		// Play the game until quitting.
		// This is too hard to express here, so we just use an infinite loop with breaks.
		while (true) {
			// Print the description of where you are.
			Place here = game.getPlace(place);
			
			System.out.println();
			System.out.println("... --- ...");
			System.out.println(here.getDescription());

			
			//print out stuff 
			System.out.println("Items in this location: " + here.getItems());
			
			// Game over after print!
			if (here.isTerminalState()) {
				break;
			}
			
			//see about refining
			//call visit() method 
			here.visit();
			
			//remove at end
			//debugging print statement
			System.out.println("Value for here.visited(): " + here.visited);
			
			//print if place has been visited before in same session of game
			if (here.visited == true) {
				System.out.println("This place feels familiar...");
			}
			
			// Show a user the ways out of this place.
			List<Exit> exits = here.getVisibleExits();

			for (int i=0; i<exits.size(); i++) {
				Exit e = exits.get(i);
				System.out.println(" "+i+". " + e.getDescription());
			}

			// Figure out what the user wants to do, for now, only "quit" is special.
			List<String> words = input.getUserWords("?");
			if (words.size() > 1) {
				System.out.println("Only give the system 1 word at a time!");
				continue;
			}

			// Get the word they typed as lowercase, and no spaces.
			// Do not uppercase action -- I have lowercased it.
			String action = words.get(0).toLowerCase().trim();
			
			
			//Allow user to quit the game by entering specific keywords.
			if (action.equals("quit") || action.equals("escape") || action.equals("q")) {
				if (input.confirm("Are you sure you want to quit?")) {
					return place;
				} else {
					continue;
				}
			}
			//Allow user to ask for help and see instructions of game.
			if (action.equals("help")) {
				System.out.println("Please input the # of the room or quit game [quit/escape/q]");
					continue;
			}
			//Allow user to search for SecretExit(s) in current location.
			if (action.equals("search")) {
				here.search();
				continue;
					
				}
			//Allow user to take all items present in room (if present). 
			if (action.equals("take")) {
				
				//If location doesn't have any items.
				if (here.getItems().isEmpty()) {
					System.out.println("Sorry, there are no items in this location.");
					continue;
				
				} else {
					
					System.out.println("You've taken the items.");
					for (String i : here.getItems()) { //for every item in our list of items in that room
						//System.out.println(i); ?
						//add to list of player's items)
						playerItems.add(i);
				}
				//referenced from https://www.tutorialspoint.com/java/util/arraylist_clear.htm
					
				//clears entire list of items in that room
				here.getItems().clear();
				}
			}
			
			if (action.equals("stuff")) {
				if (!playerItems.isEmpty()) {
					System.out.println("These are your items: " + playerItems);
				} else {
					System.out.println("You have nothing.");
				}
				
			}
			

			// From here on out, what they typed better be a number!
			Integer exitNum = null;
			try {
				exitNum = Integer.parseInt(action);
			} catch (NumberFormatException nfe) {
				System.out.println("That's not something I understand! Try a number!");
				continue;
			}

			if (exitNum < 0 || exitNum >= exits.size()) {
				System.out.println("I don't know what to do with that number!");
				continue;
			}

			// Move to the room they indicated.
			Exit destination = exits.get(exitNum);
			place = destination.getTarget();
		}

		return place;
	}

	/**
	 * This is where we play the game.
	 * @param args
	 */
	public static void main(String[] args) {
		// This is a text input source (provides getUserWords() and confirm()).
		TextInput input = TextInput.fromArgs(args);

		// This is the game we're playing.
		GameWorld game = new SpookyMansion();

		// Actually play the game.
		runGame(input, game);

		// You get here by typing "quit" or by reaching a Terminal Place.
		System.out.println("\n\n>>> GAME OVER <<<");
	}

}
