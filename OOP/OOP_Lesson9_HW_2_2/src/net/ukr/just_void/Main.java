package net.ukr.just_void;

import java.util.Arrays;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		int[] array = { -1, 1, -2, 2 };
		System.out.println(Arrays.toString(array));
		System.out.println(findSmallestModule(array));

	}

	public static int findSmallestModule(int[] array) {
		Optional<Integer> a = Arrays.stream(array)
				.boxed()
				.min((o1,o2) -> Math.abs(o1) != Math.abs(o2) ? Math.abs(o1) - Math.abs(o2) : o2 - o1);
		return a.get();
	}
}
