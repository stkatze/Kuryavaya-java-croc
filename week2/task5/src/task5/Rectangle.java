package task5;

public class Rectangle extends Figure {
	private Coordinates leftCoordinate;
	private Coordinates rightCoordinate;
	String text;

	Rectangle(Coordinates leftCoordinate, Coordinates rightCoordinate) {
		this.leftCoordinate = leftCoordinate;
		this.rightCoordinate = rightCoordinate;
	}

	@Override
	public String toString() {
		return "R (" + leftCoordinate.getX() + ", " + leftCoordinate.getY() + "), (" + rightCoordinate.getX() + ", "
				+ rightCoordinate.getY() + ")";
	}

	boolean containsCoordinate(Coordinates coord) {
		return coord.getX() >= leftCoordinate.getX() && coord.getX() <= rightCoordinate.getX()
				&& coord.getY() >= leftCoordinate.getY() && coord.getY() <= leftCoordinate.getY();
	}

	@Override
	public void move(int dx, int dy) {
		leftCoordinate.setX(leftCoordinate.getX() + dx);
		leftCoordinate.setY(leftCoordinate.getY() + dy);

		rightCoordinate.setX(rightCoordinate.getX() + dx);
		rightCoordinate.setY(rightCoordinate.getY() + dy);
	}

	@Override
	boolean containsCoordinates(Coordinates coord) {
		return false;
	}

}

