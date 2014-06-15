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
	
	public static int typeInt(){
		
		return scanner.nextInt();
		
	}
	
	public static String typeString(){
		
		return scanner.nextLine();
		
	}

}
