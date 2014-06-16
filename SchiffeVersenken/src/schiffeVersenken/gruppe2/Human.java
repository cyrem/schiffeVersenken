package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:M.J�rgens
 *
 */
public class Human implements Player,ShipConstants{

	private Battlefield bf;
	private int shipsToPlaceLeft[];
	private WeaponControl wc;
	private Player opponent;
	private String typeName="Human";
	
	public Human(){
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
	
	public void setBattlefield(Battlefield bf){
		
		this.bf=bf;
		
	}
	
	public Battlefield getBattlefield(){
		
		return bf;
		
	}
	
	
	@Override
	public void setWeaponControl(WeaponControl w){
		this.wc = new WeaponControl();
	}
	public int[] getShipsToPlaceLeft(){
		
		return shipsToPlaceLeft;
		
	}
	
	public WeaponControl getWeaponControl(){
		return this.wc;
	}
	
	public void setShipsToPlaceLeft(int index, int amount){
		
		this.shipsToPlaceLeft[index]+=amount;
		
	}
	
	/**
	 * Adds a ship with given ship size index and coordinates.
	 * It requires right information!!!
	 * 
	 * @author D.Hartkorn
	 * modified by:M.Jürgens
	 */
	public void addShip(int shipSizeIndex,Coordinate c){
		bf.getShipControl().addShipToBattlefield(bf.getShipControl().createShip(shipSizeIndex), c.getX(), c.getY(), shipSizeIndex);
		
	}
	
	/**
	 * adds all the ships
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void addShips(){
		
		int i;
		int shipSizeIndex;
		while(bf.getShipControl().noMoreShipsToPlace()==false){
			
			//print the battlefield first
			GUI.printBattlefield(bf);
			
			//show the player the options
			GUI.printText("Chose a ship to place:");
			i=0;
			while(i<shipSizes.length){
				System.out.println((i+1)+": Ship "+(i+1)+": (Width: "+shipSizes[i].getWidth()+"; Height: "+shipSizes[i].getHeight()+"; Left: "+shipsToPlaceLeft[i]);
				i++;
			}
			shipSizeIndex=GUI.typeInt()-1;
			//check whether the option is o.k
			if(shipSizeIndex<0 || shipSizeIndex>=shipSizes.length){
				GUI.printText("Wrong index!");
			}else{
				//check whether there are ships of the type left
				if(shipsToPlaceLeft[shipSizeIndex]==0){
					GUI.printText("No more ships of this type left!");
				}else{
					Coordinate c =this.bf.getCoordinateControl().getLocation();
					addShip(shipSizeIndex,c);
				}
			}
			
		}
		
		//final print after creation
		GUI.printBattlefield(bf);
		
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
		Weapon weaponSelection = wc.selectWeapon();
		Coordinate shootLoc = bf.getCoordinateControl().shootLoc();
				
		while(opponent.getBattlefield().getHit(shootLoc, weaponSelection)){
			shootLoc = bf.getCoordinateControl().shootLoc();
		}
	}
	
}
