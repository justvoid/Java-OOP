package net.ukr.just_void;

import java.util.Arrays;

public class Action {
	private int n = 0;
	private byte[] readBuffer;
	private boolean turn = false;

	public Action() {
		super();
	}

	public byte[] getReadBuffer() {
		byte[] tmp = new byte[readBuffer.length];
		System.arraycopy(readBuffer, 0, tmp, 0, readBuffer.length);
		return tmp;
	}

	public boolean isTurn() {
		return turn;
	}

	public synchronized void setTurn(boolean turn) {
		this.turn = turn;
		notifyAll();
	}

	public synchronized void readFromFile(int n, byte[] readBuffer) {
		while (turn) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.readBuffer = Arrays.copyOf(readBuffer, readBuffer.length);
		this.n = n;
		turn = true;
		notifyAll();
	}

//	public synchronized int writeToFile(byte[] readBuffer) {
//		while (!turn) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.arraycopy(this.readBuffer, 0, readBuffer, 0, readBuffer.length);
//		turn = false;
//		notifyAll();
//		return n;
//	}

	public synchronized int getN() {
		while (!turn) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return n;
	}

}
