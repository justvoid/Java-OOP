package net.ukr.just_void;

public class Main {
	
	public static void main(String[] args) {
		Dictionary dic = new Dictionary();
//		dic.addDictEntryManual();
//		dic.addDictEntryManual();
//		dic.addDictEntryManual();
//		dic.addDictEntryManual();
//		dic.addDictEntryManual();
//		dic.addDictEntryManual();
//		dic.saveDictToFile("dict.dat");
		dic.loadDictFromFile("dict.dat");
		dic.translateFile("English.in", "Ukrainian.out");

	}
}
