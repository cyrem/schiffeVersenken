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

	private class CoordinateExtended extends Coordinate{
		
		CoordinateExtended(int x, int y){
			
			super(x,y);
			
		}
		
		public boolean isValidCoordinate(Battlefield bf){
			
			if(super.getX()<0 || super.getX()>=bf.getWidth() || super.getY()<0 || super.getY()>=bf.getHeight())
				return false;
			return true;
			
		}
		
	}
	
	public boolean canCreateCoordinate(int x,int y){
		
		CoordinateExtended coords=new CoordinateExtended(x,y);
		return coords.isValidCoordinate(bf);
		
	}
	
	public boolean canCreateCoordinate(int x,int y,int offsetX,int offsetY){
		
		CoordinateExtended coords=new CoordinateExtended(x+offsetX,y+offsetY);
		return coords.isValidCoordinate(bf);
		
	}
	
	public boolean canCreateCoordinateField(int x,int y,int width,int height){
		
		if(canCreateCoordinate(x,y) && canCreateCoordinate(x,y,width,height))
			return true;
		return false;
		
	}
	
	public Coordinate createCoordinateWithOffset(int x,int y,int offsetX,int offsetY){
		
		return new Coordinate(x+offsetX,y+offsetY);
		
	}
	
}
