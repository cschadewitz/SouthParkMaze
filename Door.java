package maze;

/*
 * @author Chris Purta
 * 
 * Description: Represent a door to be opened in the maze. Its fields consist of two booleans:
 * unlocked to tell whether or not the door has been unlocked, and exists to tell whether or not the 
 * door exists. This could be potentially re-factored to a null-Door pattern by inheritance. Door will
 * set to be unlocked based upon a question that is attached to an SQLite database.
 * 
 * Work that could be done:
 * 
 * Potentially re-factor code to the null-door pattern.
 * 
 */

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

