package net.ukr.just_void;

public class Main {

	public static void main(String[] args) {
		LetterCounter lc = new LetterCounter("ghost.txt");
		lc.sortLetters(false);
		System.out.println(lc);
	}
}
