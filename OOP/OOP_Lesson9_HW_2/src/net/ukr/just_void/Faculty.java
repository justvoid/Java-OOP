package net.ukr.just_void;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Faculty {
	private String name;
	private Group[] groupList = new Group[5];

	public Faculty(String name) {
		super();
		this.name = name;
	}

	public Faculty() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group[] getGroupList() {
		return groupList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("-------" + name + "-------" + System.lineSeparator());
		for (int i = 0; i < groupList.length; i++) {
			if (groupList[i] != null) {
				sb.append(i + ". " + groupList[i].getName() + System.lineSeparator());
			}
		}
		sb.append("-------------------");
		return sb.toString();
	}

	public void addGroup(Group group) throws ContainerFullException {
		for (int i = 0; i < groupList.length; i++) {
			if (groupList[i] == null) {
				groupList[i] = group;
				System.out.println("Added group " + group.getName() + " to faculty " + name + " to place " + i);
				break;
			}
			if (i == groupList.length - 1) {
				throw new ContainerFullException(
						"Can't add " + group.getName() + "! Faculty " + name + " is already full.");
			}
		}
	}

	public void groupToFile(int i) {
		try {
			if (groupList[i] == null) {
				throw new InvalidInputException("Invalid group index!");
			}
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(groupList[i].getName() + ".txt"))) {
			oos.writeObject(groupList[i]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void groupFromFile(String address) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(address + ".txt"))) {
			this.addGroup((Group) ois.readObject());
		} catch (ContainerFullException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
