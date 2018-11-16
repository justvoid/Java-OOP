package net.ukr.just_void;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ColaQueue cq = new ColaQueue();
		System.out.println(cq);
		cq.giveCola(readN());
		System.out.println(cq);

	}
	
	public static int readN() {
		int n = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N: ");
		n = sc.nextInt();
		sc.close();
		return n;
	}

}
