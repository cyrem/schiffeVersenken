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
	
	public ShipControl getShipControl(){
		
		return shipControl;
		
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
					shipsForEachPosition[ship.getCoordinate().getX()+j][ship.getCoordinate().getY()+k]++;
				}
			}
		}
		
		return shipsForEachPosition;
		
	}
	
	public String toString(){
		
		String result = "";
		char[][] field = new char[width][height];
		int[][] ships = this.countShipsForEachPosition();
		
		//set char array
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				field[x][y] = '~';
				if(hits[x][y]){
					field[x][y] = 'o';
				}
				if(ships[x][y] > 0){
					field[x][y] = 'S';
					if(hits[x][y]){
						field[x][y] = 'X';
					}
				}
			}
		}
		result += " ";
		
		for(int i = 0; i < width; i++){
			if(i < 10){
				result += " ";
			}
			//x axis
			result += " " + (i + 1);
		}
		result += "\n";
		
		for(int y = 0; y < height; y++){
			//y axis
			result += (char) (y + 1 + 64);
			for(int x = 0; x < width; x++){
				result += "  " + field[x][y];
			}
			result += "\n";
		}
		return result;
		
	}
	
}
