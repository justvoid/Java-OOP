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

	private void checkFolder() {
		Thread th = Thread.currentThread();
		File[] files;
		File[] filesNew;
		boolean fileExists = false;

		while (!th.isInterrupted()) {
			files = folder.listFiles();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			filesNew = folder.listFiles();
			for (int i = 0; i < files.length; i += 1) {
				fileExists = false;
				for (int j = 0; j < filesNew.length; j += 1) {
					if (files[i].getName().equals(filesNew[j].getName())) {
						fileExists = true;
						continue;
					}
				}
				if (!fileExists) {
					System.out.println("Файл " + files[i].getName() + " был удален!");
				}
			}
			for (int i = 0; i < filesNew.length; i += 1) {
				fileExists = false;
				for (int j = 0; j < files.length; j += 1) {
					if (filesNew[i].getName().equals(files[j].getName())) {
						fileExists = true;
						continue;
					}
				}
				if (!fileExists) {
					System.out.println("Файл " + filesNew[i].getName() + " был добавлен!");
				}
			}			
		}
	}

	@Override
	public void run() {
		checkFolder();
	}

}
