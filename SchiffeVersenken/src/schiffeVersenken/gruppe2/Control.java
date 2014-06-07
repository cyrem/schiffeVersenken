package schiffeVersenken.gruppe2;

public class Control {

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
	
}
