package net.ukr.just_void;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
	private int n;

	public FactorialThread(int n) {
		super();
		this.n = n;
	}

	public int getN() {
		return n;
	}

	private BigInteger calculateFactorial(int number) {
		BigInteger fact = new BigInteger("1");
		for (int i = 2; i <= number; i += 1) {
			fact = fact.multiply(new BigInteger("" + i));
		}
		return fact;
	}

	@Override
	public void run() {
		System.out.println(n + "! = " + calculateFactorial(n));
	}

}
