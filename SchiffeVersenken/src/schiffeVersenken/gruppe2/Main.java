package schiffeVersenken.gruppe2;

public class Main {

	public static void main(String[] args) {
		
		Battlefield bf=new Battlefield(10,10);
		bf.getShipControl().addShipToBattlefield(new Ship(4,1), 0, 0);
		System.out.println(bf.toString());

	}

}
