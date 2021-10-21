package task4;

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
}