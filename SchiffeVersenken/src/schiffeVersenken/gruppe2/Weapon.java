package schiffeVersenken.gruppe2;
/**
 * 
 * @author Mathias Jürgens
 * modified by: D.Hartkorn
 *
 */
public class Weapon {
	private final String name;
	private final String description;
	private int amount;
	private boolean destroyShipInstant;
	
	Weapon(String n,int a, String d,boolean destroyShipInstant){
		
		this.name = n;
		this.description = d;
		this.amount = a;
		this.destroyShipInstant=destroyShipInstant;
	}
	
	public String getName(){
		return this.name;
	}

	public String getDescription(){
		return this.description;
	}
	public int getAmount(){
		return this.amount;
	}
	
	public boolean getDestroyShipInstant(){
		
		return destroyShipInstant;
		
	}
	
	/**
	 * 
	 * @author Mathias Jürgens
	 * modified by: D.Hartkorn (-1 for unlimited ammo)
	 *
	 */
	public void decreaseAmmo(){
		if(amount!=-1)
			amount--;
	}
}
