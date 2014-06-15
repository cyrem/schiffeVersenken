package schiffeVersenken.gruppe2;

import java.util.Scanner;

/**
 * 
 * @author D.Hartkorn modified by:-
 * 
 */
public class CoordinateControl implements Control {

	Scanner scan = new Scanner(System.in);
	private Battlefield bf;

	CoordinateControl(Battlefield bf) {

		this.bf = bf;

	}

	/**
	 * Coordinate class which can check if it fits onto the battlefield
	 * 
	 * @author D.Hartkorn modified by:-
	 * 
	 */
	private class CoordinateExtended extends Coordinate {

		CoordinateExtended(int x, int y) {

			super(x, y);

		}

		/**
		 * checks if it fits onto the battlefield
		 * 
		 * @author D.Hartkorn modified by:-
		 * @param bf
		 * @return
		 */
		public boolean isValidCoordinate(Battlefield bf) {

			// checks if the coordinate is in the range of the battlefield
			if (super.getX() < 0 || super.getX() >= bf.getWidth()
					|| super.getY() < 0 || super.getY() >= bf.getHeight())
				return false;
			return true;

		}

	}

	/**
	 * checks if the coordinate fits onto the battlefield
	 * 
	 * @author D.Hartkorn modified by:-
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean canCreateCoordinate(int x, int y) {

		CoordinateExtended coords = new CoordinateExtended(x, y);
		return coords.isValidCoordinate(bf);

	}

	/**
	 * checks if the coordinate fits onto the battlefield
	 * 
	 * @author M.J�rgens modified by:-
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean canCreateCoordinate(Coordinate c) {

		CoordinateExtended coords = new CoordinateExtended(c.getX(), c.getY());
		return coords.isValidCoordinate(bf);

	}

	/**
	 * checks if the coordinate with a given offset fits onto the battlefield
	 * 
	 * @author D.Hartkorn modified by:-
	 * @param x
	 * @param y
	 * @param offsetX
	 * @param offsetY
	 * @return
	 */
	public boolean canCreateCoordinate(int x, int y, int offsetX, int offsetY) {

		CoordinateExtended coords = new CoordinateExtended(x + offsetX, y
				+ offsetY);
		return coords.isValidCoordinate(bf);

	}

	/**
	 * checks the edge points of a range of coordinates, if the given field is
	 * onto the battlefield
	 * 
	 * @author D.Hartkorn modified by:-
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public boolean canCreateCoordinateField(int x, int y, int width, int height) {

		// check top left and bottom right corner
		if (canCreateCoordinate(x, y)
				&& canCreateCoordinate(x, y, width, height))
			return true;
		return false;

	}

	/**
	 * creates a coordinate with a given offset
	 * 
	 * @author D.Hartkorn modified by:-
	 * @param x
	 * @param y
	 * @param offsetX
	 * @param offsetY
	 * @return
	 */
	public Coordinate createCoordinateWithOffset(int x, int y, int offsetX,
			int offsetY) {

		return new Coordinate(x + offsetX, y + offsetY);

	}
	/**
	 * get Location
	 * 
	 * @author Mathias Jürgens modified by:D.Hartkorn(moved from battlefield to
	 *         this class)
	 * 
	 */
	public Coordinate getLocation() {
		boolean retVal = false;
		Coordinate shoot;
		while (retVal == false) {
			GUI.printText("Input Coordinates, Example Format: B7");
			String in = GUI.typeString();
			in.trim();

			if (in.length() == 2) {
				try {
					shoot = new Coordinate(Integer.parseInt(in
							.substring(1)) - 1, (char) (in.charAt(0) - 1));
					if (canCreateCoordinate(shoot)) {
						retVal = true;
						return shoot;
					} else {
						GUI.printText("Invalid Coordinates, try again");
					}
				} catch (Exception e) {
					//
				}

			}

		}
		return null;
	}

	/**
	 * pick loc to shoot
	 * 
	 * @author Mathias J�rgens modified by:D.Hartkorn(moved from battlefield to
	 *         this class)
	 * 
	 */
	public Coordinate shootLoc() {
		System.out.println("Shoot!");
		return this.getLocation();
	}

}
