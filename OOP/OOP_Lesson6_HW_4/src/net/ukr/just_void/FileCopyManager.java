package net.ukr.just_void;

import java.io.File;

public class FileCopyManager implements Runnable {
	private String in;
	private String out;
	private int maxThreadNumber;

	public FileCopyManager(String in, String out, int maxThreadNumber) {
		super();
		this.in = in;
		this.out = out;
		this.maxThreadNumber = maxThreadNumber;
	}

	public String getIn() {
		return in;
	}

	public String getOut() {
		return out;
	}

	public int getThreadNumber() {
		return maxThreadNumber;
	}

	private void startFileCopyThreads() {
		File folderIn = new File(in);
		File[] fileArray = folderIn.listFiles();
		Thread[] thArray = new Thread[fileArray.length];
		int threadsRunning = 0;

		for (int i = 0; i < fileArray.length; i += 1) {
			thArray[i] = new Thread(new FileCopyThread(fileArray[i], out));
		}
		for (int i = 0; i < fileArray.length; i += 1) {
			thArray[i].run();
			threadsRunning += 1;
			while (threadsRunning >= maxThreadNumber) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					break;
				}
				threadsRunning = 0;
				for (int j = 0; j <= i; j += 1) {
					if (thArray[j].isAlive()) {
						threadsRunning += 1;
					}
				}
			}
		}
	}

	@Override
	public void run() {
		startFileCopyThreads();
	}

}
