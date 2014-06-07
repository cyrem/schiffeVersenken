package schiffeVersenken.gruppe2;

/**
 * 
 * @author M.Jürgens
 * modified by:D.Hartkorn
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//----------TEST----------
		Player player=new AI();
		//Player player=new Human();
		Battlefield bf=new Battlefield(10,10,player);
		player.addShips();
		System.out.println(bf.toString());
		//----------TEST END----------

	}

}
