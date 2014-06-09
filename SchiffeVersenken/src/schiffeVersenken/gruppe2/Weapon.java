package schiffeVersenken.gruppe2;
/**
 * 
 * @author Mathias Jürgens
 * 
 *
 */
public class Weapon {
	private final String name;
	private final String description;
	private int amount;
	
	Weapon(String n,int a, String d){
		
		this.name = n;
		this.description = d;
		this.amount = a;
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
	public void decreaseAmmo(){
		this.amount--;
	}
}
