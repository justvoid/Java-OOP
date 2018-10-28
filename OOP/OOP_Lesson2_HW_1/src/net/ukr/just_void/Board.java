package net.ukr.just_void;

import java.util.Arrays;

public class Board {
	private Shape[] content = new Shape[4];

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(Shape[] content) {
		super();
		this.content = content;
	}

	public Shape[] getContent() {
		return content;
	}

	public void setContent(Shape[] content) {
		this.content = content;
	}

	public void addToBoard(Shape shape) {
		boolean addedElement = false;
		for (int i = 0; i < content.length; i++) {
			if (content[i] == null) {
				content[i] = shape;
				addedElement = true;
				System.out.println(shape.getName() + " помещен на место " + i);
				break;
			}
		}
		if (!addedElement) {
			System.out.println("ƒоска переполнена! " + shape.getName() + " не добавлен");
		}

	}

	public void addToBoard(Shape shape, int index) {
		if (content[index] == null) {
			content[index] = shape;
			System.out.println(shape.getName() + " помещен на место " + index);
		} else {
			System.out.println("Ёто место уже зан€то! ‘игуру можно поместить только на свободное место");
		}

	}

	public void removeFromBoard() {
		for (int i = 0; i < content.length; i++) {
			content[i] = null;
		}
		System.out.println("¬се фигуры удалены с доски");
	}

	public void removeFromBoard(Shape a) {
		boolean shapeExists = false;
		for (int i = 0; i < content.length; i++) {
			if (content[i] != null) {
				if (content[i] == a) {
					System.out.println(content[i].getName() + " удален с доски");
					content[i] = null;
					shapeExists = true;
				}
			}
		}
		if (!shapeExists) {
			System.out.println("Ќо доске нет фигур типа " + a.getName());
		}
	}

	public void removeFromBoard(int index) {
		if (content[index] != null) {
			System.out.println(content[index].getName() + "удален с места " + index);
			content[index] = null;
		} else {
			System.out.println("Ќа месте " + index + " нет фигур!");
		}
	}

	public double listBoardContent() {
		double totalArea = 0;
		for (int i = 0; i < content.length; i++) {
			if (content[i] != null) {
				totalArea += content[i].calculateArea();
				System.out.println(content[i].getName() + " на месте " + i);
			}
			 
		}
		return totalArea;
	}

	@Override
	public String toString() {
		return "Board [content=" + Arrays.toString(content) + "]";
	}

}
