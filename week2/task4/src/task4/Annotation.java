package task4;

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

}