import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
	private int[] turnList;
	private int index;


	public DancingBug(int[] turns)
	{
		turnList = turns; //initializes arrayList of number of turns
		index = 0;

	}


	public void act()
	{
		for(int i = 0; i < turnList[index]; i++)
			turn();
		super.act();
		index++;
		if(index == turnList.length)
			index = 0;

	}


}