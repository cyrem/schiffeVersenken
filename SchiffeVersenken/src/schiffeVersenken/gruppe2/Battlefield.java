package schiffeVersenken.gruppe2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author D.Hartkorn
 * modified by:R.Dietrich(added toString)
 *
 */
public class Battlefield implements BattlefieldConstants{

	//dimensions
	private final int width;
	private final int height;
	//hits by shots
	private boolean hits[][];
	//list of every ship on the battlefield
	private LinkedList<ShipOnBattlefield> ships;
	//controls coordinates
	private CoordinateControl coordsControl;
	//controls ships
	private ShipControl shipControl;
	//player of the battlefield
	private Player player;
	
	/**
	 * Constructor
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param width
	 * @param height
	 */
	public Battlefield(int width,int height,Player player){
		
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
		
		//depends on constants of interface
		shipControl=new ShipControl(this,shipMinDistance,shipMaxOverlap);
		
		this.player=player;
		
		player.setBattlefield(this);
		
	}
	
	public LinkedList<ShipOnBattlefield> getShips(){
		
		return ships;
		
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
	
	public Player getPlayer(){
		
		return player;
		
	}
	
	/**
	 * counts the ships for each position of the whole battlefield
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @return
	 */
	public int[][] countShipsForEachPosition(){
		
		int shipsForEachPosition[][]=new int[width][height];
		
		//set the counter of each position to 0
		for(int i=0;i<width;i++){
			for(int j=0;j<width;j++){
				shipsForEachPosition[i][j]=0;
			}
		}
		
		//go through all the ships
		for(Iterator<ShipOnBattlefield> i=ships.iterator();i.hasNext();){
			ShipOnBattlefield ship=i.next();
			//add 1 to the counter for each ship field
			for(int j=0;j<ship.getWidth();j++){
				for(int k=0;k<ship.getHeight();k++){
					shipsForEachPosition[ship.getCoordinate().getX()+j][ship.getCoordinate().getY()+k]++;
				}
			}
		}
		
		return shipsForEachPosition;
		
	}
	
	/**
	 * prints the battlefield
	 * 
	 * @author R.Dietrich
	 * modified by:D.Hartkorn(fixed bug of swapped x and y)
	 */
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
