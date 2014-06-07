package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class ShipControl implements Control{

	private Battlefield bf;
	private int minDistance;
	private int maxOverlap;
	
	/**
	 * Constructor
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param bf
	 * @param minDistance
	 * @param maxOverlap
	 */
	ShipControl(Battlefield bf,int minDistance,int maxOverlap){
		
		this.bf=bf;
		this.minDistance=minDistance;
		this.maxOverlap=maxOverlap;
		
	}
	
	/**
	 * Checks if the ship can be placed at this position.
	 * Recognizes the minimal distance of the ships and the maximal amount of overlapping ships
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param ship
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean canOverlapAtField(Ship ship,int x,int y){
		
		int shipsAtPosition[][]=bf.countShipsForEachPosition();
		
		//calculate edge points of the range to check
		int minX=x-minDistance;
		int maxX=x+ship.getWidth()+minDistance;
		int minY=y-minDistance;
		int maxY=y+ship.getHeight()+minDistance;
		
		//prevents wrong coordinates (out of map)
		if(minX<0)
			minX=0;
		if(minY<0)
			minY=0;
		if(maxX>=bf.getWidth())
			maxX=bf.getWidth()-1;
		if(maxY>=bf.getHeight())
			maxY=bf.getHeight()-1;
		
		//check for counted ships for each position in the range
		for(int i=minX;i<maxX;i++){
			for(int j=minY;j<maxY;j++){
				if(shipsAtPosition[i][j]>maxOverlap)
					return false;
			}
		}
		
		return true;
		
	}
	
	/**
	 * checks if the ship can be placed at a given position
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param ship
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean canCreateShipAtPosition(Ship ship,int x,int y){
		
		//checks if ship is not out of map and if it follows the right distance and overlap rules
		return (bf.getCoordinateControl().canCreateCoordinateField(x, y, ship.getWidth(), ship.getHeight())
				&& canOverlapAtField(ship,x,y));
		
	}
	
	/**
	 * Tries to add a ship onto the battlefield.
	 * Prints a message when the position is bad.
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param ship
	 * @param x
	 * @param y
	 */
	public void addShipToBattlefield(Ship ship,int x,int y){
		
		//checks if the ship can be placed onto the given position of the battlefield
		if(canCreateShipAtPosition(ship,x,y)){
			ShipOnBattlefield shipOnBattlefield=new ShipOnBattlefield(x,y,ship.getWidth(),ship.getHeight());
			//adds the ship
			bf.addShip(shipOnBattlefield);
		}else{
			System.out.println("Cannot create Ship at this position");
		}
		
	}
	
	public void clearShipsInBattlefield(){
		
		bf.getShips().clear();
		
	}
	
}
