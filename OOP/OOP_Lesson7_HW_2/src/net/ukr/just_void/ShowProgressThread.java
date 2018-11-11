package net.ukr.just_void;

import java.io.File;

public class ShowProgressThread implements Runnable {
	private ReadThread reader;
	private String fileName;

	public ShowProgressThread(ReadThread reader) {
		super();
		this.reader = reader;
		this.fileName = reader.getFileName();
	}

	@Override
	public void run() {
		long progress;
		long length = new File(fileName).length() - 1;
		do {
			progress = reader.getnTotal();
			System.out.println((progress * 100 / (length)) + "%");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (progress < length);

	}

}
