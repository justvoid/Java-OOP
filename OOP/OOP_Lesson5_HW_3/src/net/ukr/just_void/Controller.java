package net.ukr.just_void;

import java.io.IOException;
import java.util.Arrays;

public class Controller {
	private GroupIOInterface fileReadWriteInterface = new GroupIOInterface();
	private Group[] groupList = new Group[10];
	private int numberOfGroups = 0;

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addGroup(Group gr) {
		if (groupExists(gr)) {
			System.out.println("Group name must be unique! Group not added");
		} else {
			if (numberOfGroups == groupList.length) {
				resizeGroupList();
			}
			groupList[numberOfGroups++] = gr;
		}
	}

	private void resizeGroupList() {
		this.groupList = Arrays.copyOf(groupList, groupList.length * 3 / 2);
	}

	private boolean groupExists(Group group) {
		for (int i = 0; i < numberOfGroups; i++) {
			if (groupList[i].getName().equalsIgnoreCase(group.getName())) {
				return true;
			}
		}
		return false;
	}

	private boolean groupExists(String name) {
		for (int i = 0; i < numberOfGroups; i++) {
			if (groupList[i].getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public void groupToFile(Group group) {
		if (!groupExists(group)) {
			System.out.println(
					"Group with this name does not exist in Controller! Please add group first to unlock full functionality");
		} else {
			try {
				fileReadWriteInterface.saveGroup(group);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Group groupFromFile(String name) {
		if (groupExists(name)) {
			System.out.println("This group already exists!");
			return null;
		} else
			try {
				addGroup(fileReadWriteInterface.loadGroup(name));
				return groupList[numberOfGroups - 1];
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}

}
