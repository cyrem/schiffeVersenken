package schiffeVersenken.gruppe2;

import java.util.Scanner;

/**
 * 
 * @author D.Hartkorn
 * modified by:M.J�rgens
 *
 */
public class Human implements Player,ShipConstants{

	private Battlefield bf;
	private int shipsToPlaceLeft[];
	private Scanner scanner = new Scanner(System.in);
	private WeaponControl wc;
	
	public Human(){
		shipsToPlaceLeft=new int[shipSizes.length];
		for(int i=0;i<shipSizes.length;i++)
			shipsToPlaceLeft[i]=shipSizes[i].getAmount();
		
	}
	
	public void setBattlefield(Battlefield bf){
		
		this.bf=bf;
		
	}
	
	
	@Override
	public void setWeaponControl(WeaponControl w){
		this.wc = new WeaponControl();
	}
	public int[] getShipsToPlaceLeft(){
		
		return shipsToPlaceLeft;
		
	}
	
	public WeaponControl getWeaponControl(){
		return this.wc;
	}
	
	public void setShipsToPlaceLeft(int index, int amount){
		
		this.shipsToPlaceLeft[index]+=amount;
		
	}
	
	/**
	 * Adds a ship with given ship size index and coordinates.
	 * It requires right information!!!
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void addShip(int shipSizeIndex,int x, int y){
		
		bf.getShipControl().addShipToBattlefield(bf.getShipControl().createShip(shipSizeIndex), x, y, shipSizeIndex);
		
	}
	
	/**
	 * adds all the ships
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void addShips(){
		
		int i;
		int shipSizeIndex;
		int x;
		int y;
		while(bf.getShipControl().noMoreShipsToPlace()==false){
			
			//print the battlefield first
			System.out.println(bf.toString());
			
			//show the player the options
			System.out.println("Chose a ship to place:");
			i=0;
			while(i<shipSizes.length){
				System.out.println(i+": Ship "+(i+1)+": (Width: "+shipSizes[i].getWidth()+"; Height: "+shipSizes[i].getHeight()+"; Left: "+shipsToPlaceLeft[i]);
				i++;
			}
			shipSizeIndex=scanner.nextInt();
			//check whether the option is o.k
			if(shipSizeIndex<0 || shipSizeIndex>=shipSizes.length){
				System.out.println("Wrong index!");
			}else{
				//check whether there are ships of the type left
				if(shipsToPlaceLeft[shipSizeIndex]==0){
					System.out.println("No more ships of this type left!");
				}else{
					//let him chose the coordinates
					System.out.println("Chose an x-coordinate");
					x=scanner.nextInt();
					System.out.println("Chose an y-coordinate");
					y=scanner.nextInt();
					addShip(shipSizeIndex,x,y);
				}
			}
			
		}
		
		//final print after creation
		System.out.println(bf.toString());
		
	}
	
	/**
	 * pick loc to shoot
	 * 
	 * @author Mathias J�rgens
	 * 
	 */
	
	@Override
	public void shoot() {
		String WeaponSelection = this.wc.selectWeapon();
		Coordinate shootLoc = this.bf.shootLoc();
				
		
	}
	
}
