package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class CoordinateControl implements Control{

	private Battlefield bf;
	
	CoordinateControl(Battlefield bf){
		
		this.bf=bf;
		
	}

	/**
	 * Coordinate class which can check if it fits onto the battlefield
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 *
	 */
	private class CoordinateExtended extends Coordinate{
		
		CoordinateExtended(int x, int y){
			
			super(x,y);
			
		}
		
		/**
		 * checks if it fits onto the battlefield
		 * 
		 * @author D.Hartkorn
		 * modified by:-
		 * @param bf
		 * @return
		 */
		public boolean isValidCoordinate(Battlefield bf){
			
			//checks if the coordinate is in the range of the battlefield
			if(super.getX()<0 || super.getX()>bf.getWidth() || super.getY()<0 || super.getY()>bf.getHeight())
				return false;
			return true;
			
		}
		
	}
	
	/**
	 * checks if the coordinate fits onto the battlefield
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean canCreateCoordinate(int x,int y){
		
		CoordinateExtended coords=new CoordinateExtended(x,y);
		return coords.isValidCoordinate(bf);
		
	}
	/**
	 * checks if the coordinate fits onto the battlefield
	 * 
	 * @author M.Jürgens
	 * modified by:-
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean canCreateCoordinate(Coordinate c){
		
		CoordinateExtended coords=new CoordinateExtended(c.getX(),c.getY());
		return coords.isValidCoordinate(bf);
		
	}
	
	
	/**
	 * checks if the coordinate with a given offset fits onto the battlefield
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param x
	 * @param y
	 * @param offsetX
	 * @param offsetY
	 * @return
	 */
	public boolean canCreateCoordinate(int x,int y,int offsetX,int offsetY){
		
		CoordinateExtended coords=new CoordinateExtended(x+offsetX,y+offsetY);
		return coords.isValidCoordinate(bf);
		
	}
	
	/**
	 * checks the edge points of a range of coordinates, if the given field is onto the battlefield
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public boolean canCreateCoordinateField(int x,int y,int width,int height){
		
		//check top left and bottom right corner
		if(canCreateCoordinate(x,y) && canCreateCoordinate(x,y,width,height))
			return true;
		return false;
		
	}
	
	/**
	 * creates a coordinate with a given offset
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @param x
	 * @param y
	 * @param offsetX
	 * @param offsetY
	 * @return
	 */
	public Coordinate createCoordinateWithOffset(int x,int y,int offsetX,int offsetY){
		
		return new Coordinate(x+offsetX,y+offsetY);
		
	}
	
}
