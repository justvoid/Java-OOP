package net.ukr.just_void;

import java.io.File;

public class FileMonitor implements Runnable {
	private File folder;

	public FileMonitor(File folder) {
		super();
		this.folder = folder;
	}

	public File getFolder() {
		return folder;
	}

	private void compareFileArrays(File[] arr1, File[] arr2, String message) {
		boolean fileExists;
		for (int i = 0; i < arr1.length; i += 1) {
			fileExists = false;
			for (int j = 0; j < arr2.length; j += 1) {
				if (arr1[i].getName().equals(arr2[j].getName())) {
					fileExists = true;
					continue;
				}
			}
			if (!fileExists) {
				System.out.println("Файл " + arr1[i].getName() + " был " + message + "!");
			}
		}
	}
	private void compareFileArrays2(File[] arr1, File[] arr2, String message) {
		boolean fileExists;
		for (File file1 : arr1) {
			fileExists = false;
			for (File file2 : arr2) {
				if (file1.getName().equals(file2.getName())) {
					fileExists = true;
					continue;
				}
			}
			if (!fileExists) {
				System.out.println("Файл " + file1.getName() + " был " + message + "!");
			}
		}
	}
	
	private void checkFolder() {
		Thread th = Thread.currentThread();
		File[] files;
		File[] filesNew;

		while (!th.isInterrupted()) {
			files = folder.listFiles();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			filesNew = folder.listFiles();
			compareFileArrays2(files, filesNew, "удален");
			compareFileArrays2(filesNew, files, "добавлен");
		}
	}

	@Override
	public void run() {
		checkFolder();
	}

}
