package schiffeVersenken.gruppe2;

import java.util.Scanner;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class GameControl implements Control,BattlefieldConstants{

	private Scanner scanner = new Scanner(System.in);
	private Player player1;
	private Player player2;
	
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
		//player1
		int option=-1;
		while(option!=0 && option!=1){
			System.out.println("Chose player1: 0=bot; 1=human");
			option=scanner.nextInt();
		}
		if(option==0){
			player1=new AI();
		}else{
			player1=new Human();
		}
		
		//player2
		option=-1;
		while(option!=0 && option!=1){
			System.out.println("Chose player2: 0=bot; 1=human");
			option=scanner.nextInt();
		}
		if(option==0){
			player2=new AI();
		}else{
			player2=new Human();
		}
		
		//add battlefields
		new Battlefield(bfWidth,bfHeight,player1);
		new Battlefield(bfWidth,bfHeight,player2);
		
		//opponents
		player1.setOpponent(player2);
		player2.setOpponent(player1);
		
	}
	
	/**
	 * let the players add the ships
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void addShips(){
		
		System.out.println("It is time for player1 to create his ships!");
		try{
			player1.addShips();
		}catch(CannotPlaceShipsException e){System.err.println(e.toString());}
		
		System.out.println("It is time for player2 to create his ships!");
		try{
			player2.addShips();
		}catch(CannotPlaceShipsException e){System.err.println(e.toString());}
		
	}
	
	/**
	 * game play: shooting
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void shoot(){
		
		while(player1.getBattlefield().noMoreShips()==false && player2.getBattlefield().noMoreShips()==false){
			
			player1.shoot();
			System.out.println(player2.getBattlefield().toString());
			if(player2.getBattlefield().noMoreShips()==false){
				player2.shoot();
				System.out.println(player1.getBattlefield().toString());
			}
			
		}
		
		if(player1.getBattlefield().noMoreShips()==false)
			System.out.println("Player 1 ("+player1.getTypeName()+") won!");
		else
			System.out.println("Player 2 ("+player2.getTypeName()+") won!");
		
	}
	
}
