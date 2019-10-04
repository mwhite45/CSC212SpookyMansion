package edu.smith.cs.csc212.spooky;

import java.util.List;

public class LockedExit extends Exit { //make key as paramegter
	
	boolean isSecret;
	public String key;
	
	public LockedExit(String target, String description) {
		super(target, description);
		
		this.isSecret = false;
		this.key = "key";
	}
	
	public boolean isSecret() {
		return this.isSecret;
	}
	
	public void search() {
		this.isSecret = false;
	}
	
	public boolean canOpen(List<String> stuff) {
		for (here.getItems() : here.get) {
			if (this.key.equals()) {
				
			}
		} else {
			return false;
		}
				
	}

}
