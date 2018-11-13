package net.ukr.just_void;

public class Main {

	public static void main(String[] args) {
		BlackList bl = new BlackList();
		Stack st = new Stack(bl);
		Stack st1 = new Stack();
		st.push(st1);
		st.push("Hello world!");
		st.push(42);
		bl.addToBlackList(String.class);
		bl.addToBlackList(11);
		st.push("Hello world!");
		st.push(42);

		

	}
}
