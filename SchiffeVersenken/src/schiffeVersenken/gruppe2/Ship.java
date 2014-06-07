package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class Ship {

	private final int width;
	private final int height;
	private boolean hits[][];
	
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
	
	public void hitByShot(){}
	
	public boolean isAlive(){
		
		int i=0;
		int j=0;
		while(i<width){
			while(j<height){
				if (hits[i][j]==false)
					return true;
			}
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
