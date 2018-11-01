package net.ukr.just_void;

public class IntList {
	private int[] arr = new int[10];
	private int n;

	public void add(int number) {
		if (n == arr.length - 1) {
			this.resize();
		}
		arr[n++] = number;
	}

	public class IntIterator {
		private int pointer = 0;

		public boolean hasNext() {
			return pointer < IntList.this.n;
		}

		public int next() {
			IntList.this.arr[pointer] = 0;
			return IntList.this.arr[pointer++];
		}
	}

	public IntIterator getIterator() {
		return this.new IntIterator();
	}

	private void resize() {
		int[] temp = new int[(arr.length * 7) / 4];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		arr = temp;
	}

}
