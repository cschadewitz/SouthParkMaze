package maze;


public class Door {
	
	private boolean unlocked;
	private boolean exists;
	
	public Door()
	{
		this.unlocked = false;
		this.exists = false;
	}
	
	public Door(boolean l, boolean e)
	{
		this.unlocked = l;
		this.exists = e;
	}

	public void unlock()
	{
		//Need to set up a TriviaItem that tells whether or not 
		//the question was answered correctly or incorrectly
		this.unlocked = true;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

}

