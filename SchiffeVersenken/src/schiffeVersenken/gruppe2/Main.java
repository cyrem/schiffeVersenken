package schiffeVersenken.gruppe2;

/**
 * 
 * @author M.Jürgens
 * modified by:D.Hartkorn
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//----------GAME START----------
		GameControl gc=new GameControl();
		gc.init();
		gc.addShips();
		//----------GAME END----------

	}

}
