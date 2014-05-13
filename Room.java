package maze;


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
	
	public Room(int top, int right, int bottom, int left)
	{
		//Top door
		if(top != -1 && top != 0)
			this.upperDoor = new Door(false, true);
		else
			this.upperDoor = new Door(false, false);
		
		//Right door
		if(right != -1 && right != 0)
			this.rightDoor = new Door(false, true);
		else
			this.rightDoor = new Door(false, false);
		
		//Bottom door
		if(bottom != -1 && bottom != 0)
			this.lowerDoor = new Door(false, true);
		else
			this.lowerDoor = new Door(false, false);
		
		//Left door
		if(left != -1 && left != 0)
			this.leftDoor = new Door(false, true);
		else
			this.leftDoor = new Door(false, false);
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

