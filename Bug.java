package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Bug extends Actor
{

    public Bug() //constructs red bug (default)
    {
        setColor(Color.RED);
    }


    public Bug(Color bugColor) //constructs bug of given color (custom)
    {
        setColor(bugColor);
    }


    public void act() //moves if it can move, turns otherwise
    {
        if (canMove())
            move();
        else
            turn();
    }


    public void turn() //turns the bug 45 degrees to the right without changing its location
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }


    public void move() //moves the bug forward, putting a flower into the location it previously occupied
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }


    public boolean canMove() //Tests whether this bug can move forward into a location that is empty or contains flower
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
}
