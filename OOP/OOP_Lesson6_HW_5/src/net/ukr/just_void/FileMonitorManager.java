package net.ukr.just_void;

import java.io.File;

public class FileMonitorManager implements Runnable {
	private String path;

	public FileMonitorManager(String path) {
		super();
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	@Override
	public void run() {
		Thread th = new Thread(new FileMonitor(new File(path)));
		th.start();
	}

}
