import info.gridworld.actor.Bug;
import info.gridworld.grid.Location; //import if you want to do Location.NORTHEAST etc

public class VBug extends Bug
{
	private int steps;
	private int sideLength;
	private int stage;

	public VBug(int length)
	{
		steps = 0;
		sideLength = length;
		stage = 1;
		setDirection(135); //SET DIRECTION NUMBERS
	}

	public void act()
	{
		if(steps < sideLength && canMove())
		{
			move();
			steps++;
		}
		else if(stage==1)
		{
			/*
			for(int i = 0; i < 6; i++)
				turn();
			*/
			setDirection(Location.NORTHEAST); //SET DIRECTION WITH CARDINAL
			steps = 0;
			stage++;
		}
		else if(stage == 2)
			stage++; //doesn't reset steps, so it stops
	}

}