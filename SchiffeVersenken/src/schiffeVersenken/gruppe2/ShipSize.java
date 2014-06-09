package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class ShipSize {

	private final int width;
	private final int height;
	private final int amount;
	
	public ShipSize(int width, int height, int amount){
		
		this.width=width;
		this.height=height;
		this.amount=amount;
		
	}
	
	public int getWidth(){
		
		return width;
		
	}
	
	public int getHeight(){
		
		return height;
		
	}
	
	public int getAmount(){
		
		return amount;
		
	}
	
}
