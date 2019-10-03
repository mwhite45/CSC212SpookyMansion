package edu.smith.cs.csc212.spooky;

public class SecretExit extends Exit {
	
	boolean isSecret;
	private boolean hidden;

	
	public SecretExit(String target, String description) {
		super(target, description);
		
		this.isSecret = true;
		this.hidden = true;
	}
	
	public boolean isSecret() {
		return this.isSecret;
	}
	
	public void findSecretExit() {
		this.isSecret = false;
	}
	
	public void search() { //make it not secret
		//override Exit's
		/*for (Exit w: exits) {
			if(w.isSecret()) {
				((SecretExit)w).findSecretExit();
			}
		} */
	}


}
