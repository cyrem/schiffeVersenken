package schiffeVersenken.gruppe2;

public class Main {

	public static void main(String[] args) {
		
		Battlefield bf=new Battlefield(10,10);
		bf.getShipControl().addShipToBattlefield(new Ship(4,1), 0, 0);
		bf.getShipControl().addShipToBattlefield(new Ship(2,2), 3, 3);
		bf.getShipControl().addShipToBattlefield(new Ship(1,1), 2, 2);
		bf.getShipControl().addShipToBattlefield(new Ship(2,1), 8, 5);
		bf.getShipControl().addShipToBattlefield(new Ship(2,1), 9, 5);
		System.out.println(bf.toString());

	}

}
