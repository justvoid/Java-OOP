package net.ukr.just_void;

import java.util.Arrays;

public class Square extends Shape {
	private Point[] apex = new Point[4];

	public Square() {
		super(" вадрат");
		// TODO Auto-generated constructor stub
	}

	public Square(Point[] apex) {
		super(" вадрат");
		this.apex = apex;
	}

	public Square(String name, Point[] apex) {
		super(name);
		this.apex = apex;
	}

	public Square(String name, String color, Point[] apex) {
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
		return Math.pow(calculateSideLenght(apex[0], apex[1]), 2);
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
		return "Square [" + super.toString() + ", apex=" + Arrays.toString(apex) + "]";
	}

}
