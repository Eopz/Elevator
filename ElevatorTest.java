import java.util.*;
public class ElevatorTest{
	
	public static void main(String[] args) throws InterruptedException{
		
		
		//Initialize Building with 20 floors
		ElevatorCluster myElevators = new ElevatorCluster(5);
		Random r = new Random();
		for(int i = 0; i < 2; i++){
			myElevators.addElevator();
		}
		
		for(int i = 0; i < 5; i++){
			myElevators.requestElevator(r.nextInt(5) + 1);
		}
		
		for(int i = 0; i < 50; i++){
			
			myElevators.step();
			myElevators.printElevators();
			
			Thread.sleep(2000);
		}
		
	}
}