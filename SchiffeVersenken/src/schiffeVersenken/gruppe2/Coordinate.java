package schiffeVersenken.gruppe2;

/**
 * 
 * @author R.Dietrich
 * modified by:-
 *
 */
public class Coordinate
{
	private int x;
	private int y;
	
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public Coordinate(int x, char y)
	{
		this.x = x;
		this.y = Character.toUpperCase(y) - 64;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void move(int x, int y)
	{
		this.x += x;
		this.y += y;
	}
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
}