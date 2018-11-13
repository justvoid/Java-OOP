package net.ukr.just_void;

public class Stack {
	private int tos;
	private Object[] stack;
	private BlackList blackList;

	public Stack() {
		super();
		this.stack = new Object[10];
		this.tos = -1;
	}

	public Stack(BlackList blackList) {
		super();
		this.stack = new Object[10];
		this.tos = -1;
		this.blackList = blackList;
	}

	public BlackList getBlackList() {
		return blackList;
	}

	public void setBlackList(BlackList blackList) {
		this.blackList = blackList;
	}

	private void growStack() {
		Object[] tmp = new Object[stack.length + 10];
		System.arraycopy(stack, 0, tmp, 0, stack.length);
		stack = tmp;
		System.out.println("Stack grows");
	}

	public void push(Object obj) {
		if (tos == stack.length - 1) {
			growStack();
		}
		if ((blackList != null) && (blackList.isInBlackList(obj))) {
			System.out.println("This object type is in the black list! Object not added.");
		} else {
			stack[++tos] = obj;
			System.out.println("Added element " + obj + " to " + tos);
		}
	}

	public Object pop() {
		if (tos < 0) {
			System.out.println("Stack is empty");
			return null;
		}
		return stack[tos--];
	}

	public Object popClone() {
		if (tos < 0) {
			System.out.println("Stack is empty");
			return null;
		}
		return stack[tos];
	}

}
