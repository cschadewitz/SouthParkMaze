package maze;

/*
 * @author Chris Purta
 * 
 * Description: Room class that represented four Doors that are all set to be unlocked
 * 
 */

public class Room {
	
	private Door leftDoor;
	private Door rightDoor;
	private Door upperDoor;
	private Door lowerDoor;

	public Room() {
		this.leftDoor = new Door(false, false);
		this.rightDoor = new Door(false, false);
		this.upperDoor = new Door(false, false);
		this.lowerDoor = new Door(false, false);
	}
	
	public Room(boolean top, boolean right, boolean bottom, boolean left)
	{
		this.upperDoor = new Door(false, top);
		this.rightDoor = new Door(false, right);
		this.lowerDoor = new Door(false, bottom);
		this.leftDoor = new Door(false, left);
	}

	public Door getLeftDoor() {
		return leftDoor;
	}

	public void setLeftDoor(Door leftDoor) {
		this.leftDoor = leftDoor;
	}

	public Door getRightDoor() {
		return rightDoor;
	}

	public void setRightDoor(Door rightDoor) {
		this.rightDoor = rightDoor;
	}

	public Door getUpperDoor() {
		return upperDoor;
	}

	public void setUpperDoor(Door upperDoor) {
		this.upperDoor = upperDoor;
	}

	public Door getLowerDoor() {
		return lowerDoor;
	}

	public void setLowerDoor(Door lowerDoor) {
		this.lowerDoor = lowerDoor;
	}

}

