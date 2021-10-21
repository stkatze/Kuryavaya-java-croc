package task5;

public class Circle extends Figure {

	private Coordinates center;
	private int radius;

	Circle(Coordinates center, int r) {
		this.center = center;
		this.radius = r;
	}

	@Override
	public String toString() {
		return "C (" + center.getX() + ", " + center.getY() + ") " + radius;
	}

	@Override
	boolean containsCoordinates(Coordinates coord) {
		return (Math.pow((coord.getX() - center.getX()), 2) + Math.pow((coord.getY() - center.getY()), 2)) <= Math
				.pow(radius, 2);
	}

	@Override
	public void move(int dx, int dy) {
		center.setX(center.getX() + dx);
		center.setY(center.getY() + dy);
	}
}
