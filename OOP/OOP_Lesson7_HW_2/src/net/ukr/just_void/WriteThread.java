package net.ukr.just_void;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteThread implements Runnable {
	private String fileName;
	private Action act;
	private File file;
	

	public WriteThread(String fileName, Action act) {
		super();
		this.fileName = fileName;
		this.act = act;
	}
	
	private void createNewFile() {
		file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		int n;
		byte[] buffer;
		createNewFile();
		try (FileOutputStream fos = new FileOutputStream(file)) {
			while ((n = act.getN()) > 0) {
				buffer = act.getReadBuffer();
				act.setTurn(false);
				fos.write(buffer, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
