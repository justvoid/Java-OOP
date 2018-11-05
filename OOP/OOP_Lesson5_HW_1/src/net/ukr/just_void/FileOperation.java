package net.ukr.just_void;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {
	public static void fileCopy(File in, File out) throws IOException {
		byte[] buffer = new byte[1024 * 1024];
		int readByte = 0;
		try (FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out)) {
			for (; (readByte = fis.read(buffer)) > 0;) {
				fos.write(buffer, 0, readByte);
			}
		} catch (IOException e) {
			throw e;
		}
	}

	public static void folderCopy(File in, File out, FileFilter ff) throws IOException {
		File[] fileList = in.listFiles();
		for (File file : fileList) {
			if (ff.accept(file)) {
				try {
					File outFile = new File(out, file.getName());
					outFile.createNewFile();
					fileCopy(file, outFile);
					System.out.println(file.getAbsolutePath() + "\t" + "Copied to" + "\t" + outFile.getAbsolutePath());
				} catch (IOException e) {
					throw e;
				}
			}
		}
	}

	public static long calculateFolderSize(File file) {
		if (file.isFile()) {
			return file.length();
		} else {
			long size = 0;
			File[] fileArray = file.listFiles();
			for (File file2 : fileArray) {
				size += calculateFolderSize(file2);
			}
			return size;
		}
	}
}
