package net.ukr.just_void;

public class SumThread implements Runnable {
	private int[] array;
	private int start;
	private int end;
	private int sum;

	public SumThread(int[] array, int start, int end) {
		super();
		this.array = array;
		this.start = start;
		this.end = end;
	}

	public int getSum() {
		return sum;
	}

	@Override
	public void run() {
//		Thread th = Thread.currentThread();
		sum = 0;
		for (int i = start; i < end; i += 1) {
			sum += array[i];
		}
//		System.out.println(th.getName() +" закончил работу. Сумма = " + sum);
		
	}

}
