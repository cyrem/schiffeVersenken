package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:M.Jürgens
 *
 */
public interface Player {
	public void setWeaponControl(WeaponControl c);
	public void setBattlefield(Battlefield bf);
	public void addShips() throws Exception;
	public void addShip(int shipSizeIndex,int x,int y);
	public int[] getShipsToPlaceLeft();
	public void setShipsToPlaceLeft(int index, int amount);
	public void shoot();
	
}
