package schiffeVersenken.gruppe2;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class GameControl implements Control,BattlefieldConstants{

	private Scanner scanner = new Scanner(System.in);
	int playerAmount=2;
	private Player players[]=new Player[playerAmount];
	private Player opponents[]=new Player[playerAmount];
	private Timer timer= new Timer();
	private int timeLimit = 15*60;
	private int winner = 0;
	
	GameControl(){}
	
	/**
	 * Creates the battlefields and players
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void init(){
		
		GUI.printText("WELCOME TO BATTLESHIP SIMULATOR 2015!!!\n");
		
		//chose players
		for(int i=0;i<playerAmount;i++){
			
			int option=-1;
			while(option!=0 && option!=1){
				GUI.printText("Chose player1: 0=bot; 1=human");
				option=GUI.typeInt();
			}
			if(option==0){
				players[i]=new AI();
			}else{
				players[i]=new Human();
			}
			
			//add battlefields
			new Battlefield(bfWidth,bfHeight,players[i]);
		}
		
		//opponents
		players[0].setOpponent(players[1]);
		players[1].setOpponent(players[0]);
		opponents[0]=players[1];
		opponents[1]=players[0];
		
		this.timer.schedule(new TimerTask() {
			  @Override
			  public void run() {
				  GUI.printText("took to long, you all loose!");
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
		
		for(int i=0;i<playerAmount;i++){
			GUI.printText("It is time for player"+(i+1)+" to create his ships!");
			try{
				players[i].addShips();
			}catch(CannotPlaceShipsException e){GUI.printError(e.toString());}
		}
		
	}
	
	/**
	 * game play: shooting
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 */
	public void shoot(){
		
		int i;
		boolean varGameEnd;
		
		while(gameEnd()==false){
			
			i=0;
			varGameEnd=false;
			while(i<playerAmount && varGameEnd==false){
				players[i].shoot();
				GUI.printText(opponents[i].getBattlefield().toString());
				if(gameEnd()==false)
					i++;
				else
					varGameEnd=true;
			}
			
		}
		
		GUI.printText("Player "+winner+" wins");
		
	}
	
	/**
	 * returns true when game ends and prints winner
	 * 
	 * @author D.Hartkorn
	 * modified by:-
	 * @return
	 */
	private boolean gameEnd(){
		
		boolean foundPlayerWithShips=false;
		int playerWin=0;
		
		for(int i=0;i<playerAmount;i++){
			if(players[i].getBattlefield().noMoreShips()==false){
				if(foundPlayerWithShips==true)
					return false;
				foundPlayerWithShips=true;
				playerWin=i+1;
			}
		}
		
		winner=playerWin;
		return true;
		
	}
	
}
