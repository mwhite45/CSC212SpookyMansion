package edu.smith.cs.csc212.spooky;

import java.util.List;

public class LockedExit extends Exit { //make key as paramegter
	/**
	 * An exit can be secret and not shown 
	 */
	boolean isSecret;
	/**
	 * Create key. A key is needed to unlock locked exits.
	 */
	public String key;
	
	//referenced from @author jfoley.
	/**
	 * Create a new LockedExit.
	 * @param target - where it goes.
	 * @param description - how it looks.
	 */
	
	public LockedExit(String target, String description) {
		super(target, description);
		
		this.isSecret = false;
		this.key = "key";
	}
	//next three methods are overridden.
	
	public boolean isSecret() {
		return this.isSecret;
	}
	
	public void search() {
		this.isSecret = false;
	}
	
	public boolean canOpen(List<String> stuff) {
		/*for (here.getItems() : here.get) {
			if (this.key.equals()) {
				
			} */
		//} else {
			return false;
		//}
				
	}

}
