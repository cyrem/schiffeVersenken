package schiffeVersenken.gruppe2;

import java.util.Scanner;

public class GUI {
	
	/**
	 * 
	 * @author M.Jürgens
	 * modified by:D.Hartkorn
	 *
	 */
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void printText(String s){
		System.out.println(s);
	}
	public static void printError(String s){
		System.err.println(s);
	}
	
	public static void printBattlefield(Battlefield bf){
		System.out.println(bf.toString());
	}
	
	public static int typeInt(){
		boolean hasInt= false;
		
		while(!hasInt){
			if (scanner.hasNextInt()) {
				hasInt = true;
					return scanner.nextInt();
				}else{
					GUI.printText("Not a number, again!");
					scanner.nextLine();
				}
				scanner.nextLine();
			}
		return 0;
	}
	
	
	

	
	
	public static String typeString(){
		return scanner.nextLine();
	}

}
