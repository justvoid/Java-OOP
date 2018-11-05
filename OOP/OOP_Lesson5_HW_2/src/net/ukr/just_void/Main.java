package net.ukr.just_void;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		File file1 = new File("a.txt");
		File file2 = new File("b.txt");
		try {
		copyDuplicateWords(file1, file2, new File("c.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void copyDuplicateWords(File in1, File in2, File out) throws IOException{
		try {
			String in1String = readStringFromFile(in1);
			String in2String = readStringFromFile(in2);
			writeToFile(out, compareStrings(in1String, in2String));
		} catch (IOException e) {
			throw e;
		}
	}
	
	public static String readStringFromFile(File file) throws IOException {
		String str;
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((str = br.readLine()) != null) {
				sb.append(str + " ");
			}
		} catch (IOException e) {
			throw e;
		}
		return sb.toString();
	}

	public static String compareStrings(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		String[] str1Array = str1.split(" ");
		String[] str2Array = str2.split(" ");
		for (String string1 : str1Array) {
			for (String string2 : str2Array) {
				if (string1.equalsIgnoreCase(string2)) {
					sb.append(string1 + " ");
					break;
				}
			}

		}
		return sb.toString();
	}
	
	public static void writeToFile(File file, String str) throws IOException {
		try (PrintWriter pw = new PrintWriter(file)) {
			if (!file.exists()) {
				file.createNewFile();
			}
			pw.println(str);
		} catch (IOException e) {
			throw e;
		}
	}
}
