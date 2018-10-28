package net.ukr.just_void;

import java.util.Arrays;

public class Circle extends Shape {
	private Point[] apex = new Point[2];
	private double r = 0;

	public Circle() {
		super("Круг");
	}

	public Circle(Point[] apex) {
		super("Круг");
		this.apex = apex;
		calculateR();
	}

	public Circle(String name, Point[] apex) {
		super(name);
		this.apex = apex;
	}

	public Circle(Point apex, int r) {
		super("Круг");
		this.apex[0] = apex;
		this.r = r;
		calculateApex1();
	}

	public Circle(String name, Point apex, int r) {
		super(name);
		this.apex[0] = apex;
		this.r = r;
		calculateApex1();
	}

	public Circle(String name, String color, Point[] apex) {
		super(name, color);
		this.apex = apex;
		calculateR();
	}

	public Circle(String name, String color, Point apex, double r) {
		super(name, color);
		this.apex[0] = apex;
		this.r = r;
		calculateApex1();
	}

	public Point[] getApex() {
		return apex;
	}

	public void setApex(Point[] apex) {
		this.apex = apex;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(r, 2);
	}

	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * r;
	}

	private void calculateR() {
		r = Math.sqrt(Math.pow(apex[0].getX() - apex[1].getX(), 2) + Math.pow(apex[0].getY() - apex[1].getY(), 2));
	}

	private void calculateApex1() {
		apex[1] = new Point(apex[0].getX(), apex[0].getY() + r);
	}

	@Override
	public String toString() {
		return "Circle [" + super.toString() + ", apex=" + Arrays.toString(apex) + ", r=" + r + "]";
	}

}
