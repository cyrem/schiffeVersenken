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
	 * modified by:-
	 */
	public boolean addShip(int shipSizeIndex,int x, int y){
		
		if(bf.getShipControl().addShipToBattlefield(bf.getShipControl().createShip(shipSizeIndex), x, y, shipSizeIndex))
			return true;
		return false;
		
	}
	
	public void addShip(int shipSizeIndex,Coordinate c){
		bf.getShipControl().addShipToBattlefield(bf.getShipControl().createShip(shipSizeIndex), c.getX(), c.getY(), shipSizeIndex);
		
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
				
		while(opponent.getBattlefield().getHit(shootLoc, weaponSelection));
	}
	
}
