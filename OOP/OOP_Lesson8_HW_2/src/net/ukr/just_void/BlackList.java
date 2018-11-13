package net.ukr.just_void;

public class BlackList {
	private Class<?>[] blackList;
	private int n;

	public BlackList(Class<?>[] blackList) {
		super();
		this.blackList = blackList;
		n = blackList.length;
	}

	public BlackList() {
		super();
		blackList = new Class[10];
		n = 0;
	}

	public Object[] getBlackList() {
		return blackList;
	}

	public void addToBlackList(Class<?> cl) {
		if (n == blackList.length) {
			growBlackList();
		}
		blackList[n++] = cl;
	}

	public void addToBlackList(Object obj) {
		if (n == blackList.length) {
			growBlackList();
		}
		blackList[n++] = obj.getClass();
	}

	private void growBlackList() {
		Object[] tmp = new Object[blackList.length + 10];
		System.arraycopy(blackList, 0, tmp, 0, blackList.length);
	}

	public boolean isInBlackList(Object obj) {
		for (int i = 0; i < n; i++) {
			if (blackList[i] == obj.getClass()) {
				return true;
			}
		}
		return false;
	}
}