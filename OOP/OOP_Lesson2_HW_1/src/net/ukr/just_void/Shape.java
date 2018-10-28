package net.ukr.just_void;

public abstract class Shape {
	private String name;
	private Point[] apex;
	private String color = "черный";

	public Shape() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shape(String name) {
		super();
		this.name = name;
	}

	public Shape(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point[] getApex() {
		return apex;
	}

	public void setApex(Point[] apex) {
		this.apex = apex;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	@Override
	public String toString() {
		return "name=" + name + ", color=" + color;
	}

}
