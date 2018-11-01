package net.ukr.just_void;

import java.util.Arrays;

public class Circle extends Shape {
//	private Point[] apex = new Point[2];
	private double r = 0;

	public Circle() {
		super("Круг");
	}

	public Circle(Point[] apex) {
		super("Круг");
		setApex(apex);
		calculateR();
	}

	public Circle(String name, Point[] apex) {
		super(name);
		setApex(apex);
	}

	public Circle(Point apex, int r) {
		super("Круг");
		this.r = r;
		setApex(new Point[] {apex, new Point(apex.getX(),apex.getY() + r)});
	}

	public Circle(String name, Point apex, int r) {
		super(name);
		setApex(new Point[2]);
		this.r = r;
		setApex(new Point[] {apex, new Point(apex.getX(),apex.getY() + r)});
	}

	public Circle(String name, String color, Point[] apex) {
		super(name, color);
		setApex(apex);
		calculateR();
	}

	public Circle(String name, String color, Point apex, double r) {
		super(name, color);
		setApex(new Point[2]);
		this.r = r;
		setApex(new Point[] {apex, new Point(apex.getX(),apex.getY() + r)});
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
		r = Math.sqrt(Math.pow(getApex()[0].getX() - getApex()[1].getX(), 2) + Math.pow(getApex()[0].getY() - getApex()[1].getY(), 2));
	}

	@Override
	public String toString() {
		return "Circle [" + super.toString() + ", r=" + r + "]";
	}

}
