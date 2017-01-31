Elevator.java:
It is the representation of an elevator. The elevator itself doesn't have any of the
algorithmic code in it. All it is, is a class that lets me make more elevators. A building
can have multiple elevators, so this is the approach I took to the problem where we have to
be able to make multiple elevators.

An elevator has its ID, The direction its going, the floors that are its goals, and the floor
it is currently one. The direction it is going is represented by the a direction enum which has
3 movement abilities which is up, down and not moving.


ElevatorCluster.java:
It is the representation of all the elevators. Most of the brunt work is done here. The elevator
is requested. It also keeps track of which direction each elevator should be going. Finally, the 
elevator has its movements controlled in the ElevatorCluster. Each movement also happens inside of
this class because the step function controls the movement of every elevator. Also has a function
which displays where every elevator is.

The algorithm I chose for the elevator is the elevator that is closest that is going in the direction
of the floor will go to the requested floor. I keep track of which floors each elevator goes to or 
needs to go to in Elevator.java. It is called the "goalfloors" and the elevator will make a point to
go to every goal floor. If the elevator ever finish its whole entire set of goal floors, it will stop
moving until it is the elevator requested from elevatorRequest.