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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int findLargestNumber(String fileName) throws IOException{
		Optional<Integer> output = Files.lines(Paths.get(fileName))
				.map(n -> Arrays.stream(n.split(" "))
						.map(o -> Integer.valueOf(o))
						.max((o1, o2) -> o1 - o2).get())
				.max((o1, o2) -> o1 - o2);
		return output.get();
	}

}
