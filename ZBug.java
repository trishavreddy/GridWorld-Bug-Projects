import info.gridworld.actor.Bug;


public class ZBug extends Bug
{
	private int steps;
	private int sideLength;
	private int stage;

	public ZBug(int length)
	{
		steps = 0;
		sideLength = length;
		stage = 1;
		setDirection(90);
	}

	public void act()
	{
		if(steps < sideLength && canMove() && stage < 4)
		{
			move();
			steps++;
		}
		else
		{
			if(stage==1)
			{
				for(int i = 0 ; i < 3; i++)
					turn();
				steps = 0;
				stage++;
			}
			else if (stage == 2)
			{
				for(int i = 0 ; i < 5; i++)
					turn();
				steps = 0;
				stage++;

			}
			else if(stage == 3)
			{
				stage++;
			}
		}
	}

}