package net.ukr.just_void;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadThread implements Runnable {
	private int nTotal = 0;
	private byte[] buffer = new byte[1024 * 1024];
	private String fileName;
	private Action act;

	public ReadThread(String fileName, Action act) {
		super();
		this.fileName = fileName;
		this.act = act;
	}

	public int getnTotal() {
		return nTotal;
	}

	public String getFileName() {
		return fileName;
	}

	@Override
	public void run() {
		int n = 0;
		File file = new File(fileName);
		try (FileInputStream fis = new FileInputStream(file)) {
			do {
				n = fis.read(buffer);
				nTotal += n;
				act.readFromFile(n, buffer);
			} while (n > 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
