package net.ukr.just_void;

public class Ship implements Runnable{
	String name;
	private int n;

	public Ship(String name, int n) {
		super();
		this.name = name;
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public String getName() {
		return name;
	}

	private int unload() {
		if (n > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n -= 1;
			System.out.println("На корабле " + name + " осталось " + n + " контейнеров");
			return n;
		}
		System.out.println(name + " уже пуст!");
		return -1;
	}

	@Override
	public void run() {
		for (;unload()!=-1;);
		
	}


}
