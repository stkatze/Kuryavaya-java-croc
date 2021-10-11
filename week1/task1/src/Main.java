import java.util.Scanner;

import mainz.Point;

public class Main {
    static class Point {
        double x;
        double y;
    }
	public static void main(String[] args) {
		Scanner scan= new Scanner (System.in);
		double x1, y1, x2, y2, x3, y3;
		System.out.println("Введите координату х вершины №1: ");
		x1 = scan.nextInt();
		System.out.println("Введите координату y вершины №1: ");
		y1 = scan.nextInt();
		System.out.println("Введите координату х вершины №2: ");
		x2 = scan.nextInt();
		System.out.println("Введите координату y вершины №2: ");
		y2 = scan.nextInt();
		System.out.println("Введите координату х вершины №3:");
		x3 = scan.nextInt();
		System.out.println("Введите координату y вершины №3: ");
		y3 = scan.nextInt();
		
		Point a = new Point();
	    a.x = x1;
	    a.y = y1;

	    Point b = new Point();
	    b.x = x2;
	    b.y = y2;

	    Point c = new Point();
	    c.x = x3;
	    c.y = y3;
	    

	    double p,ab,ac,cb;
	    ab = Math.sqrt((b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y));
	    ac = Math.sqrt((c.x - a.x)*(c.x - a.x) + (c.y - a.y)*(c.y - a.y));
	    cb = Math.sqrt((b.x - c.x)*(b.x - c.x) + (b.y - c.y)*(b.y - c.y));
	    
	    p=(ab + ac + cb) / 2;
	    
	    double ploshad;
	    ploshad = Math.sqrt(p* (p-ab)*(p-ac)*(p-cb));
	 
	    String answer= String.format("%.2f",ploshad);
	    System.out.println("Площадь треугольника равна: " + answer + ".");

	}

}
