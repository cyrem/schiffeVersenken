package schiffeVersenken.gruppe2;

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
	public boolean addShip(int shipSizeIndex,int x, int y){
		
		if(bf.getShipControl().addShipToBattlefield(bf.getShipControl().createShip(shipSizeIndex), x, y, shipSizeIndex))
			return true;
		return false;
		
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
		System.out.println("AI: I just chose my weapon!");
		Coordinate shootLoc = new Coordinate((int)(Math.random()*bf.getWidth()),(int)(Math.random()*bf.getHeight()));
		System.out.println("AI: I just chose a shot location!");		
		
		while(opponent.getBattlefield().getHit(shootLoc, weaponSelection));
		System.out.println("AI: I just shot!");
	}


	
}
