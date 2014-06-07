package schiffeVersenken.gruppe2;

import java.util.LinkedList;

public class Battlefield {

	private final int width;
	private final int height;
	private boolean hits[][];
	private LinkedList<Ship> ships;
	
	public Battlefield(int width,int height){
		
		this.width=width;
		this.height=height;
		
		hits=new boolean[width][height];
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				hits[i][j]=false;
			}
		}
		
		ships=new LinkedList<Ship>();
		
	}
	
	public void addShip(Ship ship){
		
		ships.addLast(ship);
		
	}
	
	public void clearShips(){
		
		ships.clear();
		
	}
	
}
