package net.ukr.just_void;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static ExecutorService exs = Executors.newFixedThreadPool(4);

	public static void main(String[] args) {
		String address = ".";
		String fileName = "a.txt";
		File folder = new File(address);
		int timeout = 30;

		searchFile(folder, fileName);
		
		exs.shutdown();
		try {
			exs.awaitTermination(timeout, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void searchFile(File folder, String name) {
		if (folder.isFile()) {
			exs.submit(new CheckFileThread(folder, name));
		} else {
			File[] fileArray = folder.listFiles();
			for (File file : fileArray) {
				searchFile(file, name);
			}
		}
	}

}
