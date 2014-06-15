package schiffeVersenken.gruppe2;

import java.util.LinkedList;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class ShipControl implements Control,ShipConstants{

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
	 * return a ShipSize with a given constant's index
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param number
	 * @return
	 */
	private ShipSize createShipSize(int shipSizeIndex){
		
		if(shipSizeIndex>=0 && shipSizeIndex<shipSizes.length)
			return shipSizes[shipSizeIndex];
		return null;
		
	}
	
	/**
	 * creates a ship with given index of the given ship sizes
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param shipSizeIndex
	 * @return
	 */
	public Ship createShip(int shipSizeIndex){
		
		ShipSize shipSize=createShipSize(shipSizeIndex);
		//index must be valid
		if(shipSize!=null)
			return new Ship(shipSize.getWidth(),shipSize.getHeight());
		return null;
		
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
			maxX=bf.getWidth();
		if(maxY>=bf.getHeight())
			maxY=bf.getHeight();
		
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
	public boolean canCreateShipAtPosition(Ship ship,int x,int y){
		
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
	public boolean addShipToBattlefield(Ship ship,int x,int y, int shipIndex){
		
		//checks if the ship can be placed onto the given position of the battlefield
		if(canCreateShipAtPosition(ship,x,y)){
			ShipOnBattlefield shipOnBattlefield=new ShipOnBattlefield(x,y,ship.getWidth(),ship.getHeight());
			//adds the ship
			bf.getShips().addLast(shipOnBattlefield);
			bf.getPlayer().setShipsToPlaceLeft(shipIndex,-1);
			return true;
		}else{
			return false;
		}
		
	}
	
	public void clearShipsInBattlefield(){
		
		bf.getShips().clear();
		
	}
	
	/**
	 * checks whether there are ships to place left
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @return
	 */
	public boolean noMoreShipsToPlace(){
		
		int i=0;
		while(i<shipSizes.length){
			if(bf.getPlayer().getShipsToPlaceLeft()[i]!=0)
				return false;
			i++;
		}
		return true;
		
	}
	
	/**
	 * returns a list that contains all possible
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @return
	 */
	public LinkedList<Coordinate> allPossiblePositions(Ship ship){
		
		LinkedList<Coordinate> possibleCoords=new LinkedList<Coordinate>();
		
		//check whole battlefield
		for(int i=0;i<bf.getWidth();i++){
			for(int j=0;j<bf.getHeight();j++){
				if(canCreateShipAtPosition(ship,i,j))
					possibleCoords.addLast(new Coordinate(i,j));
			}
		}
		
		return possibleCoords;
		
	}
	
}
