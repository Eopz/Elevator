import java.lang.*;
import java.util.*;
public class ElevatorCluster{

	ArrayList<Elevator> cluster;
	int floors;
	
	public ElevatorCluster(int floors){
		cluster = new ArrayList<Elevator>();
		this.floors = floors;
	}
	
	public void addElevator(){
		cluster.add(new Elevator(cluster.size()+1, floors));
		
	}
	
	public void requestElevator(int floor){
		
		Elevator closest = cluster.get(0);
		Direction newDirection = closest.getDirection();
		
		for(int i = 0; i < cluster.size(); i++){
		
			if(Math.abs(cluster.get(i).getFloor() - floor) <= Math.abs(closest.getFloor() - floor)){
				
				if(floor < cluster.get(i).getFloor()){
					if(cluster.get(i).getDirection() == Direction.DOWN || cluster.get(i).getDirection() == Direction.NOT_MOVING){
						closest = cluster.get(i);
						newDirection = Direction.DOWN;
					}
				}
				else if(floor > cluster.get(i).getFloor()){
					if(cluster.get(i).getDirection() == Direction.UP || cluster.get(i).getDirection() == Direction.NOT_MOVING){
						closest = cluster.get(i);
						newDirection = Direction.UP;
					}
				}
				
			}
			
		}
		
		closest.setDirection(newDirection);
		
		closest.setGoalFloor(floor);
		System.out.println(floor + " has been requested");
	}
	
	public void step(){
		
		for(int i = 0; i < cluster.size(); i++){
		
			int floor = cluster.get(i).getFloor();
			
			if(cluster.get(i).checkGoalFloor(floor)){
				cluster.get(i).removeGoalFloor(floor);
			}
			
			if(cluster.get(i).getGoalFloors() == ""){
				cluster.get(i).setDirection(Direction.NOT_MOVING);
			}
			
			System.out.println(cluster.get(i).getDirection());
			switch(cluster.get(i).getDirection()){
				
				case UP:
					cluster.get(i).upFloor();
					break;
				case DOWN:
					cluster.get(i).downFloor();
					break;
				case NOT_MOVING:
					break;
				default:
					break;
			}
			
			
		}
	}
	
	public void printElevators(){
		
		for(int i = 0; i < cluster.size(); i++){
			System.out.println("This is elevator id: " + cluster.get(i).getId());
			System.out.println("Currently have floors: " + cluster.get(i).getGoalFloors() + "as goal floors");
			System.out.println("It is currently on floor: "+cluster.get(i).getFloor());
			System.out.println("The direction it is going currently is: " + cluster.get(i).getDirection());
		}
	}
	
}