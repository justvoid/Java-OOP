package net.ukr.just_void;

import java.util.Arrays;

public class Triangle extends Shape {
	private Point[] apex = new Point[3];

	public Triangle() {
		super("Треугольник");
		// TODO Auto-generated constructor stub
	}

	public Triangle(Point[] apex) {
		super("Треугольник");
		this.apex = apex;
	}

	public Triangle(String name, Point[] apex) {
		super(name);
		this.apex = apex;
	}

	public Triangle(String name, String color, Point[] apex) {
		super(name, color);
		this.apex = apex;
	}

	public Point[] getApex() {
		return apex;
	}

	public void setApex(Point[] apex) {
		this.apex = apex;
	}

	@Override
	public double calculateArea() {
		double area;
		double[] side = new double[3];
		double halfP = 0;

		for (int i = 0; i < apex.length; i++) {
			side[i] = (i == apex.length - 1) ? calculateSideLenght(apex[i], apex[0])
					: calculateSideLenght(apex[i], apex[i + 1]);
			halfP += side[i] / 2;
		}
		area = Math.sqrt(halfP * (halfP - side[0]) * (halfP - side[1]) * (halfP - side[2]));
		return area;
	}

	@Override
	public double calculatePerimeter() {
		double p = 0;
		for (int i = 0; i < apex.length; i++) {
			p += (i == apex.length - 1) ? calculateSideLenght(apex[i], apex[i + 1])
					: calculateSideLenght(apex[i], apex[0]);
		}
		return p;
	}

	private double calculateSideLenght(Point a, Point b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}

	@Override
	public String toString() {
		return "Triangle [" + super.toString() + ", apex=" + Arrays.toString(apex) + "]";
	}

}
