package edu.smith.cs.csc212.spooky;

import java.util.List;

public class SecretExit extends Exit {
	
	boolean isSecret;
	
	//referenced from @author jfoley.
	/**
	 * Create a new SecretExit.
	 * @param target - where it goes.
	 * @param description - how it looks.
	 */
	public SecretExit(String target, String description) {
		super(target, description);
		
		this.isSecret = true;
	}
	
	//next three methods are overridden.
	
	public boolean isSecret() {
		return this.isSecret;
	}
	
	public void search() {
		this.isSecret = false;
	}
	
	public boolean canOpen(List<String> stuff) {
		return false;
	}


}
