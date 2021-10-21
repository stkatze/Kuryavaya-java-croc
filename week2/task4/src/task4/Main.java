package task4;

public class Main {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(new Coordinates(100, 100), new Coordinates(150, 200));
		Circle circle = new Circle(new Coordinates(100, 100), 10);
		Annotation annotatedRectangle = new Annotation(rectangle, "Car");
		Annotation annotatedCircle = new Annotation(circle, "Tree");
		Annotation[] annotations = new Annotation[2];
		annotations[0] = annotatedRectangle;
		annotations[1] = annotatedCircle;

		for (Annotation annotation : annotations) {
			System.out.println(annotation.getFigure().toString() + ": " + annotation.getText());
		}

	}
}
