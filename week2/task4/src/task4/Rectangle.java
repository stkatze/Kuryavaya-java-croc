package task4;

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
}
