package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class ShipOnBattlefield extends Ship{

	private Coordinate coords;
	
	ShipOnBattlefield(int x,int y,int width,int height){
		
		super(width,height);
		coords=new Coordinate(x,y);
		
	}
	
	public void hitByShot(){
		
		//to do
		
	}
	
	public boolean isAlive(){
		
		return super.isAlive();
		
	}
	
	public int getWidth(){
		
		return super.getWidth();
		
	}
	
	public int getHeight(){
		
		return super.getHeight();
		
	}
	
	public Coordinate getCoordinate(){
		
		return coords;
		
	}
	
}
