import info.gridworld.actor.Bug;
import info.gridworld.grid.Location; //import if you want to do Location.NORTHEAST etc

public class Isosceles extends Bug
{
	private int steps;
	private int sideLength;
	private int stage;

	public Isosceles(int length)
	{
		steps = 0;
		sideLength = length;
		stage = 1;
		setDirection(45);
	}

	public void act()
	{
		if(steps < sideLength && canMove())
		{
			move();
			steps++;
		}
		else if(stage == 1)
		{
			setDirection(135);
			steps = 0;
			stage++;
		}
		else if(stage == 2)
		{
			setDirection(Location.WEST);
			steps = 0;
			stage++;
		}
		else if(stage == 3)
		{
			steps = 0;
			stage++;
		}
	}

}