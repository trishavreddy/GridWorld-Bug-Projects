import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor; //add for unbounded
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.UnboundedGrid; //add for unbounded

import java.awt.Color;


public class BoxBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();

        world.setGrid(new BoundedGrid<Actor>(9,9)); //changes grid dimensions
        //world.setGrid(new UnboundedGrid<Actor>());

        BoxBug bob = new BoxBug(3);
        bob.setColor(Color.BLUE);

        CircleBug stacy = new CircleBug(4);
        stacy.setColor(Color.MAGENTA);

        SpiralBug alice = new SpiralBug(3);
        alice.setColor(Color.ORANGE);


        VBug vicky = new VBug(3);
        vicky.setColor(Color.YELLOW);

        ZBug zayn = new ZBug(4);

		int[] arr = {1,2,5,4,6,2};
        DancingBug david = new DancingBug(arr);


		//world.add(new Location(4,4), vicky);
        //world.add(new Location(7, 8), alice);
        //world.add(new Location(5, 5), bob);
        //world.add(new Location(3,2), stacy);
        //world.add(new Location(10,5), zayn);
        world.add(new Location(4,5), david);

        world.show();
    }
}