package net.ukr.just_void;

import net.ukr.just_void.IntList.IntIterator;

public class Main {
	
	public static void main(String[] args) {
		
		IntList intList = new IntList();
		intList.add(3);
		intList.add(5);
		intList.add(8);
		intList.add(11);
		intList.add(3);
		intList.add(18);
		
		IntIterator iter = intList.getIterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
	}


}
