package net.ukr.just_void;

public class Main {

	public static void main(String[] args) {
		Thread[] thArray = new Thread[100];
		for (int i = 0; i < 100; i++) {
			thArray[i] = new Thread(new FactorialThread(i), "Thread #" + (i));
		}

		for (int i = 0; i < 100; i++) {
			thArray[i].start();
		}

	}

}
