package schiffeVersenken.gruppe2;

public class Control {
	
	int testZumHochladenLoeschenBitteXD;
	
	private Battlefield bf;
	
	Control(Battlefield bf){
		
		bf=this.bf;
		
	}

	private class CoordinateControl extends Coordinate{
		
		CoordinateControl(int x, int y){
			
			super(x,y);
			
		}
		
		public void setOffset(int offsetX,int offsetY){
			
			super.setX(super.getX()+offsetX);
			super.setY(super.getY()+offsetY);
			
		}
		
		public boolean isValidCoordinate(Battlefield bf){
			
			if(super.getX()<0 || super.getX()>=bf.getWidth() || super.getY()<0 || super.getY()>=bf.getHeight())
				return false;
			return true;
			
		}
		
	}
	
	public boolean canCreateCoordinate(int x,int y){
		
		CoordinateControl coords=new CoordinateControl(x,y);
		return coords.isValidCoordinate(bf);
		
	}
	
	public boolean canCreateCoordinate(int x,int y,int offsetX,int offsetY){
		
		CoordinateControl coords=new CoordinateControl(x,y);
		coords.setOffset(offsetX, offsetY);
		return coords.isValidCoordinate(bf);
		
	}
	
	public boolean canCreateCoordinateField(int x,int y,int width,int height){
		
		CoordinateControl coordsFirst=new CoordinateControl(x,y);
		CoordinateControl coordsLast=new CoordinateControl(x,y);
		
		coordsLast.setOffset(width, height);
		
		if(coordsFirst.isValidCoordinate(bf)==true && coordsLast.isValidCoordinate(bf)==true)
			return true;
		return false;
		
	}
	
}
