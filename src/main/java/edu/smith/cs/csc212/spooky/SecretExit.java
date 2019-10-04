package edu.smith.cs.csc212.spooky;

import java.util.List;

public class SecretExit extends Exit {
	
	boolean isSecret;

	
	public SecretExit(String target, String description) {
		super(target, description);
		
		this.isSecret = true;
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
