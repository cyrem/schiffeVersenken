package schiffeVersenken.gruppe2;

import java.util.LinkedList;

/**
 * 
 * @author D.Hartkorn
 * modified by:M.Jürgens
 *
 */
public class AI implements Player,ShipConstants{

	private Battlefield bf;
	private WeaponControl wc;
	private int shipsToPlaceLeft[];
	
	public AI(){
		
		shipsToPlaceLeft=new int[shipSizes.length];
		for(int i=0;i<shipSizes.length;i++)
			shipsToPlaceLeft[i]=shipSizes[i].getAmount();
		
	}
	
	

	@Override
	public void setWeaponControl(WeaponControl w){
		this.wc = new WeaponControl();
	}
	public WeaponControl getWeaponControl(){
		return this.wc;
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
	public void addShips() throws Exception{
		
		int random;
		boolean error=false;
		LinkedList<Coordinate> allPossiblePositions;
		while(bf.getShipControl().noMoreShipsToPlace()==false && error==false){
			
			//place every ship of every type
			for(int i=0;i<shipSizes.length;i++){
				
				//place every ship of this type
				while(shipsToPlaceLeft[i]>0 && error==false){
					//get all possibilities to place this type of ship
					allPossiblePositions=bf.getShipControl().allPossiblePositions(new Ship(shipSizes[i].getWidth(),shipSizes[i].getHeight()));
					//an error occurs when there are no possibilities left
					if(allPossiblePositions.isEmpty() && bf.getShipControl().noMoreShipsToPlace()==false){
						throw new Exception("The battlefield is too small to place more ships!");
					}else{
						//get random possible position
						random=(int)(Math.random()*allPossiblePositions.size());
						//add the ship
						addShip(i,allPossiblePositions.get(random).getX(),allPossiblePositions.get(random).getY());
					}
				}
				
			}
			
		}
		System.out.println("AI: I just created my ships!");
		
	}

	/**
	 * pick loc to shoot
	 * 
	 * @author Mathias Jürgens
	 * 
	 */

	@Override
	public void shoot() {
		String WeaponSelection = this.wc.selectWeapon();
		Coordinate shootLoc = this.bf.shootLoc();
				
		
	}


	
}
