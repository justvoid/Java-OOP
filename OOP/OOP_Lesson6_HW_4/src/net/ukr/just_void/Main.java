package net.ukr.just_void;

public class Main {
	public static void main(String[] args) {
		Thread th = new Thread(new FileCopyManager("1\\", "D:\\", 4));
		th.start();
	}
}
