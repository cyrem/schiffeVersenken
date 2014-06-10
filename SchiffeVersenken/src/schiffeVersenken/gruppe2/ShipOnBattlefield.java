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
	
	/**
	 * @author D.Kern
	 * modified by:D.hartkorn(translate coords)
	 */
	public void hitByShot(Coordinate coords, Weapon weapon) {
		
		//translate positions
		super.hitByShot(new Coordinate(coords.getX()-this.coords.getX(),coords.getY()-this.coords.getY()), weapon);
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
