package net.ukr.just_void;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		int[] array = generateArray(40);
		String[] arrayStr = { "h", "a", "h", "b" };
		Double[] arrayD = {1.2, 2.4, 1.2};
//		System.out.println(Arrays.toString(arrayStr));
		printMap(count(array));
		System.out.println();
		printMap(count(arrayStr));
		System.out.println();
		printMap(count(arrayD));

	}

	public static int[] generateArray(int n) {
		int[] array = new int[n];
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
		return array;
	}

	public static <T> Map<T, Integer> count(T[] array) {
		Map<T, Integer> intMap = new HashMap<>();
		for (T i : array) {
			intMap.put(i, intMap.get(i) == null ? 1 : intMap.get(i) + 1);
		}
		return intMap;
	}
	
	public static Map<Integer, Integer> count(int[] array) {
		Integer[] arr = Arrays.stream(array).boxed().toArray(Integer[]::new);
		return count(arr);
	}
	
	public static Map<Double, Integer> count(double[] array) {
		Double[] arr = Arrays.stream(array).boxed().toArray(Double[]::new);
		return count(arr);
	}

	public static <T> void printMap(Map<T, Integer> map) {
		Set<T> keys = map.keySet();
		for (T key : keys) {
			System.out.println(key + " -> " + map.get(key));
		}
	}
}
