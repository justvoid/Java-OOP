package net.ukr.just_void;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String str = "Hello World";
		System.out.println(Arrays.toString(convertStringToAsciiArray(str))); //conversion

		for (char i : str.toCharArray()) {			//test
			System.out.print((int) i + " ");
		}
		
	}
	
	public static int[] convertStringToAsciiArray(String str) {
		return str.chars().toArray();
	}
}
