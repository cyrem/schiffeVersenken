package schiffeVersenken.gruppe2;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class GameControl implements Control,BattlefieldConstants,ShipConstants{

	private Scanner scanner = new Scanner(System.in);
	private int playerAmount=2;
	private Player players[]=new Player[playerAmount];
	private Player opponents[]=new Player[playerAmount];
	private Battlefield bfs[]=new Battlefield[playerAmount];
	private Timer timer= new Timer();
	private int timeLimit = 15*60;
	
	GameControl(){}
	
	/**
	 * Creates the battlefields and players
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void init(){
		
		System.out.println("WELCOME TO BATTLESHIP SIMULATOR 2015!!!\n");
		
		//chose players
		for(int i=0;i<playerAmount;i++){
			
			int option=-1;
			while(option!=0 && option!=1){
				System.out.println("Chose player"+(i+1)+": 0=bot; 1=human");
				option=scanner.nextInt();
			}
			if(option==0){
				players[i]=new AI();
			}else{
				players[i]=new Human();
			}
			
			//add battlefields
			bfs[i]=new Battlefield(bfWidth,bfHeight,players[i]);
		}
		
		//opponents
		players[0].setOpponent(players[1]);
		players[1].setOpponent(players[0]);
		opponents[0]=players[1];
		opponents[1]=players[0];
		
		
		
		this.timer.schedule(new TimerTask() {
			  @Override
			  public void run() {
			    System.out.println("took to long, you all loose!");
			    System.exit(0);
			  }
			}, timeLimit*1000);
	}
	
	/**
	 * let the players add the ships
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void addShips(){
		
		for(int j=0;j<playerAmount;j++){
			
			if (players[j] instanceof Human){
				
				int i;
				int shipSizeIndex;
				while(bfs[j].getShipControl().noMoreShipsToPlace()==false){
					
					//print the battlefield first
					System.out.println(bfs[j].toString());
					
					//show the player the options
					System.out.println("Chose a ship to place:");
					i=0;
					while(i<shipSizes.length){
						System.out.println((i+1)+": Ship "+(i+1)+": (Width: "+shipSizes[i].getWidth()+"; Height: "+shipSizes[i].getHeight()+"; Left: "+players[j].getShipsToPlaceLeft()[i]);
						i++;
					}
					shipSizeIndex=scanner.nextInt()-1;
					//check whether the option is o.k
					if(shipSizeIndex<0 || shipSizeIndex>=shipSizes.length){
						System.out.println("Wrong index!");
					}else{
						//check whether there are ships of the type left
						if(players[j].getShipsToPlaceLeft()[shipSizeIndex]==0){
							System.out.println("No more ships of this type left!");
						}else{
							Coordinate c =bfs[j].getCoordinateControl().getLocation();
							if(!players[j].addShip(shipSizeIndex,c.getX(),c.getY()))
								System.out.println("Cannot create Ship at this position");
						}
					}
					
				}
				
				//final print after creation
				System.out.println(bfs[j].toString());
				
			}else{
				
				int random;
				boolean error=false;
				LinkedList<Coordinate> allPossiblePositions;
				while(bfs[j].getShipControl().noMoreShipsToPlace()==false && error==false){
					
					//place every ship of every type
					for(int i=0;i<shipSizes.length;i++){
						
						//place every ship of this type
						while(players[j].getShipsToPlaceLeft()[i]>0 && error==false){
							//get all possibilities to place this type of ship
							allPossiblePositions=bfs[j].getShipControl().allPossiblePositions(new Ship(shipSizes[i].getWidth(),shipSizes[i].getHeight()));
							//an error occurs when there are no possibilities left
							if(allPossiblePositions.isEmpty() && bfs[j].getShipControl().noMoreShipsToPlace()==false){
								System.out.println("The battlefield is too small to place more ships!");
							}else{
								//get random possible position
								random=(int)(Math.random()*allPossiblePositions.size());
								//add the ship
								players[j].addShip(i,allPossiblePositions.get(random).getX(),allPossiblePositions.get(random).getY());
							}
						}
						
					}
					
				}
				System.out.println("AI: I just created my ships!");
				
			}
			
		}
		
	}
	
	/**
	 * game play: shooting
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void shoot(){
		
		/*while(players[0].getBattlefield().noMoreShips()==false && players[1].getBattlefield().noMoreShips()==false){
			
			players[0].shoot();
			System.out.println(players[1].getBattlefield().toString());
			if(players[1].getBattlefield().noMoreShips()==false){
				players[1].shoot();
				System.out.println(players[0].getBattlefield().toString());
			}
			
		}
		
		if(players[0].getBattlefield().noMoreShips()==false)
			System.out.println("Player 1 ("+players[0].getTypeName()+") won!");
		else
			System.out.println("Player 2 ("+players[1].getTypeName()+") won!");*/
		
	}
	
}
