package net.ukr.just_void;

public class Main {

	public static void main(String[] args) {
		String folder = ".";
		Thread thread = new Thread(new FileMonitorManager(folder));
		thread.start();
	}

}
