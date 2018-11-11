package net.ukr.just_void;

import java.io.File;

public class CheckFileThread implements Runnable {
	private File file;
	private String name;

	public CheckFileThread(File file, String name) {
		super();
		this.file = file;
		this.name = name;
	}

	@Override
	public void run() {
		Thread th = Thread.currentThread();
//		System.out.println(th.getName());
		if (file.getName().equalsIgnoreCase(name)) {
			System.out.println(th.getName() + "// " + file.getAbsolutePath());
		}
	}
}
