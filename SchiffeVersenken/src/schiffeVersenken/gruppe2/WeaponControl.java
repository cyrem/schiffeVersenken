package schiffeVersenken.gruppe2;

import java.util.Vector;

/**
 * 
 * @author Mathias Jürgens modified by:D.Hartkorn
 * 
 */

public class WeaponControl implements WeaponConstants {

	private Vector<Weapon> avaibleWeapons = new Vector<Weapon>();

	WeaponControl() {
		// initialize weapons
		for (Weapon w : WeaponConstants.weapons) {
			this.avaibleWeapons.add(new Weapon(w.getName(), w.getAmount(), w
					.getDescription(), w.getDestroyShipInstant()));
		}
	}

	public Weapon[] getWeapons() {

		return weapons;

	}

	/**
	 * Selects from available weapons
	 * 
	 * @author Mathias Jürgens modified by:D.Hartkorn(returns weapon, not name)
	 * 
	 */
	public Weapon selectWeapon() {
		GUI.printText("Select a Weapon");
		boolean retVal = false;
		// repeat until valid selection
		// assumes at least one option available
		while (retVal == false) {
			for (int i = 0; i < this.avaibleWeapons.size(); i++) {
				if (this.avaibleWeapons.get(i).getAmount() > 0
						|| this.avaibleWeapons.get(i).getAmount() == -1) {
					GUI.printText((i + 1) + " "
							+ this.avaibleWeapons.get(i).getName() + ", "
							+ this.avaibleWeapons.get(i).getDescription());
				}
			}
				int auswahl = GUI.typeInt() - 1;

				if (auswahl >= 0 && auswahl < this.avaibleWeapons.size() && this.avaibleWeapons.get(auswahl).getAmount() != 0) {
					retVal = true;
					this.avaibleWeapons.get(auswahl).decreaseAmmo();
					return this.avaibleWeapons.get(auswahl);
				} else {
					GUI.printText("Wrong number");
				}
			}
		return null;
	}

}
