package net.ukr.just_void;

import java.util.ArrayList;
import java.util.Random;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random rng = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(rng.nextInt(10));
		}
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
		list.remove(0);
		list.remove(0);
		list.remove(list.size() - 1);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

}
