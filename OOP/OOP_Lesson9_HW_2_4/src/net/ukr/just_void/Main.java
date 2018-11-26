package net.ukr.just_void;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println(findLargestNumber("a.txt"));
			System.out.println(findLargestNumberDouble("a.txt"));	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static double findLargestNumberDouble(String fileName) throws IOException{
		Double output = Files.lines(Paths.get(fileName))
				.mapToDouble(n -> Arrays.stream(n.split(" "))
						.mapToDouble(o -> Double.valueOf(o))
						.max().getAsDouble())
				.max().getAsDouble();
		return output;
	}

	
	public static int findLargestNumber(String fileName) throws IOException{
		int output = Files.lines(Paths.get(fileName))
				.map(n -> Arrays.stream(n.split(" "))
						.map(o -> Integer.valueOf(o))
						.max((o1, o2) -> o1 - o2).get())
				.max((o1, o2) -> o1 - o2).get();
		return output;
	}

}
