package net.ukr.just_void;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out, true);
		Set<String> addr = readFile("a.txt");
		pw.println(addr);
		for (String i : addr) {
			testConnection(i);
		}
	}

	public static Set<String> readFile(String fileName) {
		Set<String> result = new HashSet<>();
		String str = null;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			for (; ((str = br.readLine()) != null) && (str.length() > 0);) {
				result.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void testConnection(String addr) {
		int code = 0;
		try {
			URL url = new URL(addr);
			HttpURLConnection htu = (HttpURLConnection) url.openConnection();
			code = htu.getResponseCode();
			if ((code >= 200) && (code < 300)) {
				System.out.println("Connection to " + addr + " established. Code: " + code);
			} else {
				System.out.println("ERROR! Connection to " + addr + " not established. Code: " + code
						+ " Response Message :" + htu.getResponseMessage());
			}
		} catch (MalformedURLException e) {
			System.out.println("ERROR! Incorrect address " + addr);
		} catch (IOException e) {
			System.out.println("ERROR! Connection not established " + addr);
		}
	}

}
