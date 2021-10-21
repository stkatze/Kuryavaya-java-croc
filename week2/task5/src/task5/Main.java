package task5;

public class Main {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(new Coordinates(100, 100), new Coordinates(150, 200));
		Circle circle = new Circle(new Coordinates(100, 100), 10);
		Annotation annotatedRectangle = new Annotation(rectangle, "Car");
		Annotation annotatedCircle = new Annotation(circle, "Tree");
		Annotation[] annotations = new Annotation[2];
		annotations[0] = annotatedRectangle;
		annotations[1] = annotatedCircle;

		System.out.println("Массив аннотаций состоит из");
		for (Annotation annotation : annotations) {
			System.out.println(annotation.getFigure().toString() + ": " + annotation.getText());
		}
		System.out.println();

		System.out.println("Выбор аннотации по координатам точки");
		Annotation an = Annotation.findByCoordinates(annotations, 100, 100);
		if (an != null) {
			System.out.println(an.getFigure().toString() + ": " + an.getText());
		} else {
			System.out.println("Нет аннотации");
		}
		System.out.println();

		System.out.println("Выбор аннотации по шаблону подписи");
		Annotation ann = Annotation.findByText(annotations, "Tr");
		if (ann != null) {
			System.out.println(an.getFigure().toString() + ": " + an.getText());
		} else {
			System.out.println("Нет аннотации");
		}
		System.out.println();

		System.out.println("Перемещение фигуры выбранной аннотации на смещение (dx, dy)");
		System.out.println("Начальные координаты прямоугольника: ");
		System.out.println(rectangle.toString());
		rectangle.move(10, 50);
		System.out.println("Координаты прямоугольника после смещения: ");
		System.out.println(rectangle.toString());

		System.out.println("Начальные координаты круга: ");
		System.out.println(circle.toString());
		circle.move(-20, 30);
		System.out.println("Координаты круга после смещения: ");
		System.out.println(circle.toString());
	}
}
