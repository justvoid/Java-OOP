package net.ukr.just_void;

public class Main {

	public static void main(String[] args) {
		Circle circle1 = new Circle(new Point[] {new Point(0, 0), new Point(1,0)});
		System.out.println(circle1);
		Circle circle2 = new Circle("Большой зеленый круг", "зеленый", new Point(0, 0), 10);
		System.out.println(circle2);
		Triangle triangle1 = new Triangle(new Point[]{new Point(0, 0), new Point(2, 0), new Point(0, 2)});
		System.out.println(triangle1);
		System.out.println(triangle1.calculateArea());
		Square square1 = new Square("Черый квадрат", "черный", new Point[]{new Point(0, 0), new Point(2, 0), new Point(2, 2), new Point(0,2)});
		System.out.println(square1);
		Board board = new Board();
		board.addToBoard(square1);
		board.addToBoard(triangle1, 3);
		board.addToBoard(circle1);
		board.addToBoard(circle2);
		board.addToBoard(circle1);
		board.addToBoard(circle1, 1);
		board.removeFromBoard(circle1);

		System.out.println("---------");
		
		board.listBoardContent();
		System.out.println(board.toString());

		System.out.println("---------");

		board.removeFromBoard(0);
		board.removeFromBoard();
		
		Shape sh = new Square();
		System.out.println(sh instanceof Square);
		System.out.println(sh instanceof Shape);
		System.out.println(sh.getClass() == Shape.class);
//		System.out.println(sh instanceof Shape);
		
		
		

	}

}
