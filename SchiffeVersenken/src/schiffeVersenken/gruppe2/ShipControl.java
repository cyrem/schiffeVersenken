package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class ShipControl implements Control{

	private Battlefield bf;
	private int minDistance;
	private int maxOverlap;
	
	ShipControl(Battlefield bf,int minDistance,int maxOverlap){
		
		bf=this.bf;
		this.minDistance=minDistance;
		this.maxOverlap=maxOverlap;
		
	}
	
	private boolean canOverlapAtField(Ship ship,int x,int y){
		
		int shipsAtPosition[][]=bf.countShipsAtPosition();
		
		int minX=x-minDistance;
		int maxX=x+ship.getWidth()+minDistance;
		int minY=y-minDistance;
		int maxY=y+ship.getHeight()+minDistance;
		
		if(minX<0)
			minX=0;
		if(minY<0)
			minY=0;
		if(maxX>=bf.getWidth())
			maxX=bf.getWidth()-1;
		if(maxY>=bf.getHeight())
			maxY=bf.getHeight()-1;
		
		for(int i=minX;i<maxX;i++){
			for(int j=minY;j<maxY;j++){
				if(shipsAtPosition[i][j]>=maxOverlap)
					return false;
			}
		}
		
		return true;
		
	}
	
	private boolean canCreateShipAtPosition(Ship ship,int x,int y){
		
		return (bf.getCoordinateControl().canCreateCoordinateField(x, y, ship.getWidth(), ship.getHeight())
				&& canOverlapAtField(ship,x,y));
		
	}
	
	public void addShipToBattlefield(Ship ship,int x,int y){
		
		if(canCreateShipAtPosition(ship,x,y)){
			ShipOnBattlefield shipOnBattlefield=new ShipOnBattlefield(x,y,ship.getWidth(),ship.getHeight());
			bf.addShip(shipOnBattlefield);
		}else{
			System.out.println("Cannot create Ship at this position");
		}
		
	}
	
	public void clearShipsInBattlefield(){
		
		bf.getShips().clear();
		
	}
	
}
