package net.ukr.just_void;

public class Main {

	public static void main(String[] args) {
		Action act = new Action();
		ReadThread read = new ReadThread("c:\\Users\\Void\\git\\repository\\OOP\\OOP_Lesson7_HW_2\\Loop.mp4", act);
		ShowProgressThread progress = new ShowProgressThread(read);
		WriteThread write = new WriteThread("c:\\Users\\Void\\git\\repository\\OOP\\OOP_Lesson7_HW_2\\Loop4.mp4", act);
		Thread readThread = new Thread(read);
		Thread progressThread = new Thread(progress);
		Thread writeThread = new Thread(write);
		progressThread.start();
		readThread.start();
		writeThread.start();

	}

}
