package edu.smith.cs.csc212.spooky;

import java.util.List;

public class LockedExit extends Exit {
	
	boolean isSecret;
	
	public LockedExit(String target, String description) {
		super(target, description);
		
		this.isSecret = false;
	}
	
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
