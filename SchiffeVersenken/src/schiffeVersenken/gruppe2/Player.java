package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:M.J�rgens
 *
 */
public interface Player {
	
	public String getTypeName();
	public void setOpponent(Player opponent);
	public void setWeaponControl(WeaponControl c);
	public void setBattlefield(Battlefield bf);
	public Battlefield getBattlefield();
	public boolean addShip(int shipSizeIndex,int x,int y);
	public int[] getShipsToPlaceLeft();
	public void setShipsToPlaceLeft(int index, int amount);
	public void shoot();
	
}
