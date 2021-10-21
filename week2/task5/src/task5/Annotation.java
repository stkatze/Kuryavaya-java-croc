package task5;

public class Annotation {
	private String text;
	private Figure figure;

	public Annotation() {
	}

	public Annotation(Figure figure, String text) {
		this.figure = figure;
		this.text = text;
	}

	public Figure getFigure() {
		return figure;
	}

	public String getText() {
		return text;
	}

	public String toString() {
		return (figure.toString() + ": " + text);
	}

	public static Annotation findByCoordinates(Annotation[] annotations, int x, int y) {
		for (Annotation annotation : annotations) {
			if (annotation.getFigure().containsCoordinates(new Coordinates(x, y))) {
				return annotation;
			}
		}
		return null;
	}

	public static Annotation findByText(Annotation[] annotations, String text1) {
		for (Annotation annotation : annotations) {
			String text = annotation.getText();
			if (text.contains(text1))
				return annotation;
		}
		return null;
	}
}