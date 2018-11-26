package net.ukr.just_void;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class URLReader {
	private String address;
	private HttpURLConnection urlC;

	public URLReader(String address) {
		super();
		this.address = address;
		establishConnection();
	}

	public String getAddress() {
		return address;
	}

	private void establishConnection() {
		try {
			URL url = new URL(address);
			urlC = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readURL() {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(urlC.getInputStream()));
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str).append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public void printLinks(String fileName) {
		StringBuilder sb = new StringBuilder(readURL());
		Set<String> links = new HashSet<>();
		for (int start = sb.indexOf("<a"), end = sb.indexOf("</a"); start != -1; 
				sb.delete(0, end + 3), start = sb.indexOf("<a"), end = sb.indexOf("</a")) {
			if (end > start) {
				String link;
				if ((link = parseLinkFromText(sb.substring(start, end))) != null) {
					links.add(link);
				}
			}
		}
		collectionToFile(links, fileName);
	}

	private void collectionToFile(Collection<?> collection, String fileName) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)))) {
			for (Object i : collection) {
				pw.println(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String parseLinkFromText(String text) {
		StringBuilder sb = new StringBuilder(text);
		if (sb.indexOf("http") != -1) {
			sb.delete(0, sb.indexOf("http"));
			return sb.substring(0, sb.indexOf("\""));
		}
		return null;
	}

}
