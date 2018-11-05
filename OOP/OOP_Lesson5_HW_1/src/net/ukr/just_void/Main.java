package net.ukr.just_void;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		ExtensionsFileFilter eff = new ExtensionsFileFilter("jpg", "pdf");
		File folder1 = new File(".");
		File folder2 = new File("c:\\");
		try {
			FileOperation.folderCopy(folder1, folder2, eff);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
