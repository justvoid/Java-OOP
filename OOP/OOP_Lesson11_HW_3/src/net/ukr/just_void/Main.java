package net.ukr.just_void;

public class Main {

	public static void main(String[] args) {
		URLReader ur = new URLReader("https://prog.kiev.ua/forum/index.php/topic,3885.msg47408.html#msg47408");
		ur.printLinks("a.txt");
	}

}
