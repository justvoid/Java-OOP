package net.ukr.just_void;

import java.util.ArrayDeque;

public class ColaQueue {
	private ArrayDeque<String> que;

	public ColaQueue() {
		super();
		que = new ArrayDeque<>();
		initializeQueue();
	}

	private void initializeQueue() {
		que.add("Sheldon");
		que.add("Leonard");
		que.add("Volovitc");
		que.add("Kutrapalli");
		que.add("Penny");
	}

	public void giveCola(int n) {
		for (int i = 0; i < n; i++) {
			String tmp = que.poll();
			que.addLast(tmp);
			que.addLast(tmp);
		}

	}

	@Override
	public String toString() {
		return "START " + que + " END";
	}
}
