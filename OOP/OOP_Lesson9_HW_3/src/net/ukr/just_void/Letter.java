package net.ukr.just_void;

public class Letter {
	private char letter;
	private long num;

	public Letter(char letter) {
		super();
		this.letter = letter;
		this.num = 0;
	}

	public char getLetter() {
		return letter;
	}

	public long getNum() {
		return num;
	}
	
	public void incNum() {
		num++;
	}

	@Override
	public String toString() {
		return letter + " [" + num + "]";
	}

}
