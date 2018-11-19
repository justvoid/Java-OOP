package net.ukr.just_void;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dictionary {
	private HashMap<String, String> enUaDict = new HashMap<>();

	public Dictionary() {
		super();
	}

	public Map<String, String> getEnUaDict() {
		return enUaDict;
	}

	public String translate(String str) {
		if (enUaDict.get(str) != null) {
			return enUaDict.get(str);
		}
		return str;
	}

	public void translateFile(String in, String out) {
		try {
			String translation = Files.lines(Paths.get(in))
						.map(n -> Arrays.stream(n.split(" "))
								.map(o -> o.toLowerCase())
								.map(p -> translate(p))
								.collect(Collectors.joining(" ")))
						.collect(Collectors.joining(System.lineSeparator()));
			System.out.println(translation);
			writeFile(out, translation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeFile(String filename, String str) {
		try (PrintWriter pw = new PrintWriter(new File(filename))) {
			pw.print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addDictEntryManual() {
		Scanner sc = new Scanner(System.in);
		String source, translation;
		System.out.println("Enter English word: ");
		source = sc.nextLine();
		System.out.println("Enter Ukrainian translation: ");
		translation = sc.nextLine();
		addDictEntry(source, translation);
	}

	private void addDictEntry(String source, String translation) {
		enUaDict.put(source, translation);
	}

	public void saveDictToFile(String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(enUaDict);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadDictFromFile(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			enUaDict = (HashMap<String, String>) ois.readObject();
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			e.printStackTrace();
		}
	}

}
