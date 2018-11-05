package net.ukr.just_void;

import java.io.File;
import java.io.FileFilter;

public class ExtensionsFileFilter implements FileFilter {
	private String[] ext;

	public ExtensionsFileFilter(String... ext) {
		super();
		this.ext = ext;
	}

	private boolean checkExtension(String extension) {
		for (String i : ext) {
			if (i.equalsIgnoreCase(extension)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean accept(File f) {
		String fileName = f.getName();
		int index = fileName.lastIndexOf('.');
		if (index == -1) {
			return false;
		}
		return checkExtension(fileName.substring(index + 1));
	}
}