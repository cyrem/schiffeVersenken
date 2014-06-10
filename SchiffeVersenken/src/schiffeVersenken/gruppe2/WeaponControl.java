package schiffeVersenken.gruppe2;

import java.util.Scanner;
import java.util.Vector;

/**
 * 
 * @author Mathias J�rgens
 * modified by:D.Hartkorn
 *
 */

public class WeaponControl implements WeaponConstants {

	private Scanner scan = new Scanner(System.in);
	private Vector<Weapon> avaibleWeapons = new Vector<Weapon>();

	WeaponControl() {
		// initialize weapons
		for (Weapon w : WeaponConstants.weapons) {
			this.avaibleWeapons.add(new Weapon(w.getName(), w.getAmount(), w.getDescription(), w.getDestroyShipInstant()));
		}
	}
	
	public Weapon[] getWeapons(){
		
		return weapons;
		
	}
	
	/**
	 * Selects from available weapons
	 * @author Mathias J�rgens
	 * modified by:D.Hartkorn(returns weapon, not name)
	 *
	 */
	public Weapon selectWeapon() {
		System.out.println("Select a Weapon");
		boolean retVal = false;
		//repeat until valid selection
		//assumes at least one option available
		while (retVal == false) {
			for (int i = 0; i < this.avaibleWeapons.size(); i++) {
				if (this.avaibleWeapons.get(i).getAmount() > 0 || this.avaibleWeapons.get(i).getAmount() == -1) {
					System.out.println((i + 1) + " "+ this.avaibleWeapons.get(i).getName() + ", "+ this.avaibleWeapons.get(i).getDescription());
				}
			}
			
			int auswahl = scan.nextInt()-1;
	
			if (auswahl >= 0 && auswahl < this.avaibleWeapons.size()
					&& this.avaibleWeapons.get(auswahl).getAmount() != 0) {
				retVal = true;
				this.avaibleWeapons.get(auswahl).decreaseAmmo();
				return this.avaibleWeapons.get(auswahl);
			} else {
				System.out.println("Wrong number");
			}
	}
	return null;
	}

}
