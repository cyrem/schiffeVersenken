package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public interface Player {
	
	public void setBattlefield(Battlefield bf);
	public void addShips();
	public void addShip(int shipSizeIndex,int x,int y);
	public int[] getShipsToPlaceLeft();
	public void setShipsToPlaceLeft(int index, int amount);
	
}
