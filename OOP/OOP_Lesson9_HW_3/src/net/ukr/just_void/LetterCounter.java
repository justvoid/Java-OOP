package net.ukr.just_void;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LetterCounter {
	private ArrayList<Letter> letters = new ArrayList<>();

	public LetterCounter(String str) {
		super();
		initializeLetterList();
		readFromFile(new File(str));
	}

	private void initializeLetterList() {
		for (int i = 0; i < 26; i++) {
			letters.add(new Letter((char) ('a' + i)));
		}
	}

	private void readFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		String textLine;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((textLine = br.readLine()) != null) {
				sb.append(textLine + System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		countLetters(sb.toString().toLowerCase());
	}

	private void countLetters(String str) {
		char letter;
		for (int i = 0; i < str.length(); i++) {
			letter = str.charAt(i);
			if ((letter >= 'a') && (letter <= 'z')) {
				letters.get(letter - 'a').incNum();
			}
		}
	}

	public void sortLetters(boolean ascending) {
		letters.sort((a, b) -> ascending ? 1 : -1 * (Long.compare(a.getNum(), b.getNum())));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Letter letter : letters) {
			sb.append(letter.toString() + System.lineSeparator());
		}
		return sb.toString();
	}

}
