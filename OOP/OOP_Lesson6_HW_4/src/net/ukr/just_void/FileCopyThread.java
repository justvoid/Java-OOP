package net.ukr.just_void;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyThread implements Runnable{
	File file;
	String copyTo;

	public FileCopyThread(File file, String copyTo) {
		super();
		this.file = file;
		this.copyTo = copyTo;
	}

	public File getFile() {
		return file;
	}

	public String getCopyTo() {
		return copyTo;
	}

	private void copyFile(File fIn, String path) throws IOException {
		byte[] buffer = new byte[1024 * 1024];
		int readByte = 0;
		File fOut = new File(path + fIn.getName());
		fOut.createNewFile();
		try (FileInputStream fis = new FileInputStream(fIn); FileOutputStream fos = new FileOutputStream(fOut)) {
			while ((readByte = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, readByte);
			}
		} catch (IOException e) {
			throw e;
		}
	}
	
	@Override
	public void run() {
		try {
			copyFile(file, copyTo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
