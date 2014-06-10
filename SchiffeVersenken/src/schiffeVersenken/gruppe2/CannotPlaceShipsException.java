package schiffeVersenken.gruppe2;

/**
 * 
 * @author D.Hartkorn
 * modified by:-
 *
 */
public class CannotPlaceShipsException extends Exception{

	public CannotPlaceShipsException(){}
	
	public CannotPlaceShipsException(String message){
		
		super(message);
		
	}
	
}
