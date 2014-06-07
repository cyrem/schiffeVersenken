package schiffeVersenken.gruppe2;

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
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public String toString()
	{
		return "(" + x + ", " + (char)(y + 64) + ")";
	}
}