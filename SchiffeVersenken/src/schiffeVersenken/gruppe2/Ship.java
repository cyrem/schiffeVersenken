package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class Ship{

	private final int width;
	private final int height;
	private boolean hits[][];
	
	/**
	 * Constructor
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param width
	 * @param height
	 */
	public Ship(int width,int height){
		
		this.width=width;
		this.height=height;
		
		hits=new boolean[width][height];
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				hits[i][j]=false;
			}
		}
		
	}
	
	/**
	 * Handle shot at a specific position
	 * 
	 * @author D.Kern-
	 * modified by:D.Hartkorn(avoid checking for specific weapon names;stop)
	 */
	public void hitByShot(Coordinate coords, Weapon weapon){
		
		int i=coords.getX();
		int j=coords.getY();
		
		//stop when ship is not shot at
		if(i<0 || i>=width || j<0 || j>=height)
			return;
		
		if(weapon.getDestroyShipInstant()==true){
			for(int x=i; x < getWidth(); x++){
				for(int y=j; y < getHeight(); y++){
					this.hits[x][y]=true;
				}
			}
		}else{
			this.hits[i][j]=true;
		}
		
	}
	
	/**
	 * returns whether the ship is still alive
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @return
	 */
	public boolean isAlive(){
		
		int i=0;
		int j=0;
		//the ship is alive when a unharmed position is found
		while(i<width){
			while(j<height){
				if (hits[i][j]==false)
					return true;
				j++;
			}
			i++;
		}
		
		return false;
		
	}
	
	public int getWidth(){
		
		return width;
		
	}
	
	public int getHeight(){
		
		return height;
		
	}
	
}
