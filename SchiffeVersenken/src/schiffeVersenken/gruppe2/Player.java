package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:M.Jürgens
 *
 */
public interface Player {
	
	public String getTypeName();
	public void setOpponent(Player opponent);
	public void setWeaponControl(WeaponControl c);
	public void setBattlefield(Battlefield bf);
	public Battlefield getBattlefield();
	public void addShips() throws CannotPlaceShipsException;
	public void addShip(int shipSizeIndex,Coordinate c);
	public int[] getShipsToPlaceLeft();
	public void setShipsToPlaceLeft(int index, int amount);
	public void shoot();
	
}
