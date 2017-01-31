import java.util.*;
public class ElevatorTest{
	
	public static void main(String[] args) throws InterruptedException{
		
		
		//Initialize Building with 20 floors
		ElevatorCluster myElevators = new ElevatorCluster(5);
		Random r = new Random();
		for(int i = 0; i < 2; i++){
			myElevators.addElevator();
		}
		
/* 		for(int i = 0; i < 5; i++){
			myElevators.requestElevator(r.nextInt(5) + 1);
		} */
		
		for(int i = 0; i < 25; i++){
			
			myElevators.printElevators();
			myElevators.step();
			
			if(i % 5 == 0)
				myElevators.requestElevator(r.nextInt(5) + 1);
			
			Thread.sleep(5000);
		}
		
	}
}