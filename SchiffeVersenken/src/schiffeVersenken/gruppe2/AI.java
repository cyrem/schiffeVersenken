package schiffeVersenken.gruppe2;

import java.util.LinkedList;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class AI implements Player,ShipConstants{

	private Battlefield bf;
	private int shipsToPlaceLeft[];
	
	public AI(){
		
		shipsToPlaceLeft=new int[shipSizes.length];
		for(int i=0;i<shipSizes.length;i++)
			shipsToPlaceLeft[i]=shipSizes[i].getAmount();
		
	}
	
	public void setBattlefield(Battlefield bf){
		
		this.bf=bf;
		
	}
	
	public int[] getShipsToPlaceLeft(){
		
		return shipsToPlaceLeft;
		
	}
	
	public void setShipsToPlaceLeft(int[] shipsToPlaceLeft, int index){
		
		this.shipsToPlaceLeft[index]=shipsToPlaceLeft[index];
		
	}
	
	public void setShipsToPlaceLeft(int index, int amount){
		
		this.shipsToPlaceLeft[index]+=amount;
		
	}
	
	/**
	 * Adds a ship with given ship size index and coordinates.
	 * It requires right information!!!
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void addShip(int shipSizeIndex,int x, int y){
		
		bf.getShipControl().addShipToBattlefield(bf.getShipControl().createShip(shipSizeIndex), x, y, shipSizeIndex);
		
	}
	
	/**
	 * adds all the ships
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void addShips(){
		
		int random;
		boolean error=false;
		LinkedList<Coordinate> allPossiblePositions;
		int r1;
		int r2;
		while(bf.getShipControl().noMoreShipsToPlace()==false && error==false){
			
			//place every ship of every type
			for(int i=0;i<shipSizes.length;i++){
				
				//place every ship of this type
				while(shipsToPlaceLeft[i]>0 && error==false){
					//get all possibilities to place this type of ship
					allPossiblePositions=bf.getShipControl().allPossiblePositions(new Ship(shipSizes[i].getWidth(),shipSizes[i].getHeight()));
					//an error occurs when there are no possibilities left
					if(allPossiblePositions.isEmpty() && bf.getShipControl().noMoreShipsToPlace()==false){
						error=true;
					}else{
						//get random possible position
						random=(int)(Math.random()*allPossiblePositions.size());
						//add the ship
						addShip(i,allPossiblePositions.get(random).getX(),allPossiblePositions.get(random).getY());
					}
				}
				
			}
			
		}
		if(error==true){
			System.out.println("The battlefield is too small to place more ships!");
		}
		
	}
	
}
