package schiffeVersenken.gruppe2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class Battlefield {

	private final int width;
	private final int height;
	private boolean hits[][];
	private LinkedList<ShipOnBattlefield> ships;
	private CoordinateControl coordsControl;
	private ShipControl shipControl;
	
	public Battlefield(int width,int height){
		
		this.width=width;
		this.height=height;
		
		hits=new boolean[width][height];
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				hits[i][j]=false;
			}
		}
		
		ships=new LinkedList<ShipOnBattlefield>();
		
		coordsControl=new CoordinateControl(this);
		
		shipControl=new ShipControl(this,1,0);
		
	}
	
	public LinkedList<ShipOnBattlefield> getShips(){
		
		return ships;
		
	}
	
	public void addShip(ShipOnBattlefield ship){
		
		ships.addLast(ship);
	}
	
	public void clearShips(){
		
		ships.clear();
		
	}
	
	public int getWidth(){
		
		return width;
		
	}
	
	public int getHeight(){
		
		return height;
		
	}
	
	public CoordinateControl getCoordinateControl(){
		
		return coordsControl;
		
	}
	
	public int getShipAmount(){
		
		return ships.size();
		
	}
	
	public int[][] countShipsForEachPosition(){
		
		int shipsForEachPosition[][]=new int[width][height];
		
		for(int i=0;i<width;i++){
			for(int j=0;j<width;j++){
				shipsForEachPosition[i][j]=0;
			}
		}
		
		for(Iterator<ShipOnBattlefield> i=ships.iterator();i.hasNext();){
			ShipOnBattlefield ship=i.next();
			for(int j=0;j<ship.getWidth();j++){
				for(int k=0;k<ship.getHeight();k++){
					shipsForEachPosition[ship.getCoordinate().getX()][ship.getCoordinate().getY()]++;
				}
			}
		}
		
		return shipsForEachPosition;
		
	}
	
}
