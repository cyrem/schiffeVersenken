package schiffeVersenken.gruppe2;

import java.util.LinkedList;

/**
 * 
 * @author D.Hartkorn
 * modified by:M.J�rgens
 *
 */
public class AI implements Player,ShipConstants{

	private Battlefield bf;
	private WeaponControl wc;
	private int shipsToPlaceLeft[];
	private Player opponent;
	private String typeName="Bot";
	
	public AI(){
		
		shipsToPlaceLeft=new int[shipSizes.length];
		for(int i=0;i<shipSizes.length;i++)
			shipsToPlaceLeft[i]=shipSizes[i].getAmount();
		
		wc=new WeaponControl();
		
	}
	
	public String getTypeName(){
		
		return typeName;
		
	}
	
	public void setOpponent(Player opponent){
		
		this.opponent=opponent;
		
	}

	@Override
	public void setWeaponControl(WeaponControl w){
		this.wc = new WeaponControl();
	}
	public WeaponControl getWeaponControl(){
		return this.wc;
	}
	
	public Battlefield getBattlefield(){
		
		return bf;
		
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
	public void addShip(int shipSizeIndex,Coordinate c){
		
		bf.getShipControl().addShipToBattlefield(bf.getShipControl().createShip(shipSizeIndex), c.getX(),c.getY(), shipSizeIndex);
		
	}
	
	/**
	 * adds all the ships
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void addShips() throws CannotPlaceShipsException{
		
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
						throw new CannotPlaceShipsException("The battlefield is too small to place more ships!");
					}else{
						//get random possible position
						random=(int)(Math.random()*allPossiblePositions.size());
						//add the ship
						addShip(i,allPossiblePositions.get(random));
					}
				}
				
			}
			
		}
		GUI.printText("AI: I just created my ships!");
		
	}

	/**
	 * pick loc to shoot
	 * 
	 * @author Mathias J�rgens
	 * modified by:D.Hartkorn(hit)
	 * 
	 */

	@Override
	public void shoot() {
		Weapon weaponSelection = wc.getWeapons()[0];
		GUI.printText("AI: I just chose my weapon!");
		Coordinate shootLoc = new Coordinate((int)(Math.random()*bf.getWidth()),(int)(Math.random()*bf.getHeight()));
		GUI.printText("AI: I just chose a shot location!");		
		
		while(opponent.getBattlefield().getHit(shootLoc, weaponSelection)){
			shootLoc = new Coordinate((int)(Math.random()*bf.getWidth()),(int)(Math.random()*bf.getHeight()));
		}
		GUI.printText("AI: I just shot!");
	}


	
}
