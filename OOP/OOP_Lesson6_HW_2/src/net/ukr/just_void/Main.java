package net.ukr.just_void;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[200_000_000];
		int sum = 0;
		int threadNumber = 4;
		SumThread[] sumArray = new SumThread[threadNumber];
		Thread[] threadArray = new Thread[threadNumber];
		long startTime, endTime;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (10 * Math.random());
//			arr[i] = 1;		// ��� ������������
		}

		startTime = System.currentTimeMillis();
		for (int i = 0; i < threadArray.length; i += 1) {
			threadArray[i] = new Thread(sumArray[i] = new SumThread(arr, i * (arr.length / threadArray.length),
					(i + 1) * (arr.length / threadArray.length)));
		}
		for (int i = 0; i < threadArray.length; i += 1) {
			threadArray[i].start();
		}
		for (int i = 0; i < threadArray.length; i += 1) {
			try {
				threadArray[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < threadArray.length; i += 1) {
			sum += sumArray[i].getSum();
		}
		endTime = System.currentTimeMillis();

		System.out.println("������������� ����������: ");
		System.out.println(
				"����� = " + sum + System.lineSeparator() + "��������� ������� - " + (endTime - startTime) + "ms");
		System.out.println();

		startTime = System.currentTimeMillis();
		sum = 0;
		for (int i = 0; i < arr.length; i += 1) {
			sum += arr[i];
		}
		endTime = System.currentTimeMillis();
		System.out.println("������������ ����������: ");
		System.out.println(
				"����� = " + sum + System.lineSeparator() + "��������� ������� - " + (endTime - startTime) + "ms");

	}

}
