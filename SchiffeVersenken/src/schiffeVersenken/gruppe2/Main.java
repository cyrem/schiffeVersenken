package schiffeVersenken.gruppe2;

/**
 * 
 * @author M.J�rgens
 * modified by:D.Hartkorn
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//----------GAME START----------
		GameControl gc=new GameControl();
		gc.init();
		gc.addShips();
		gc.shoot();
		//----------GAME END----------

	}

}
