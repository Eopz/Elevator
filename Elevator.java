public class Elevator{
	
	private int elevatorId;
	private int floor;
	private boolean[] goalFloors;
	private Direction d;
	
	public Elevator(int id, int currFloor, int floors){
		elevatorId = id;
		floor = currFloor;
		goalFloors = new boolean[floors + 1];
		d = Direction.NOT_MOVING;
	}
	
	public Elevator(int id, int floors){
		this(id, 1, floors);
	}
	
	public void upFloor(){
		floor++;
	}
	
	public void downFloor(){
		floor--;
	}
	
	public void setFloor(int floor){
		this.floor = floor;
	}
	public int getFloor(){
		return floor;
	}
	
	public void setDirection(Direction d){
		this.d = d;
	}
	
	public Direction getDirection(){
		return d;
	}
	
	public void setGoalFloor(int i){
		goalFloors[i] = true;
	}
	
	public void removeGoalFloor(int i){
		goalFloors[i] = false;
	}
	
	public boolean checkGoalFloor(int i){
		return goalFloors[i];
	}
	
	public int getId(){
		return elevatorId;
	}
	
	public String getGoalFloors(){
		String floors = "";
		for(int i = 1; i < goalFloors.length; i++){
			if(goalFloors[i])
				floors += i + " ";
		}
		
		return floors;
	}
	
}