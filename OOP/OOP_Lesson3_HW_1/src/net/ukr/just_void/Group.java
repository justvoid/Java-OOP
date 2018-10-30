package net.ukr.just_void;

import java.util.Arrays;

public class Group {
	private String name;
	private Student[] studentList = new Student[10];

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Student[] getStudentList() {
		return studentList;
	}

	public void addStudent(Student student) throws GroupFullException, DuplicateStudentException {
		boolean studentExists = false;
		int emptyElementIndex = -1;
		for (int i = 0; i < studentList.length; i++) {

			if (studentList[i] == null) {
				emptyElementIndex = (emptyElementIndex == -1) ? i : emptyElementIndex;
			} else {
				studentExists = (studentList[i].equals(student)) || (studentExists);
			}
		}
		if (studentExists) {
			throw new DuplicateStudentException("The student " + student.getSurname() + " " + student.getName()
					+ " is already present in group " + name + "!");

		} else if (emptyElementIndex == -1) {
			throw new GroupFullException("Can't add " + student.getSurname() + " " + student.getName() + "! The group "
					+ name + " is already full.");
		} else {
			studentList[emptyElementIndex] = student;
			System.out.println("Added student " + student.getSurname() + " " + student.getName() + " to group " + name
					+ " to place " + emptyElementIndex);
		}
	}

	public void deleteStudent(Student student) {
		boolean studentFound = false;
		for (int i = 0; i < studentList.length; i++) {
			if ((studentList[i] != null) && (studentList[i].equals(student))) {
				studentFound = true;
				studentList[i] = null;
				System.out.println("Removed student " + student.getSurname() + " " + student.getName() + " from group "
						+ name + " place " + i);
			}
		}
		if (!studentFound) {
			System.out.println(
					"Student " + student.getSurname() + " " + student.getName() + " was not found in group " + name);
		}

	}

	public void deleteStudent(int index) {
		if (studentList[index] != null) {
			System.out.println("Removed student " + studentList[index].getSurname() + " " + studentList[index].getName()
					+ " from group " + name + " place " + index);
			studentList[index] = null;
		} else {
			System.out.println("There is no student in the group " + name + " under the number " + index + " !");
		}
	}

	public void groupSortNull() {
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i] == null) {
				for (int j = studentList.length - 1; j > i; j--) {
					if (studentList[j] != null) {
						studentList[i] = studentList[j];
						studentList[j] = null;
						break;
					}
				}
			}
		}
	}

	public void groupSort() {
		groupSortNull();
		boolean madeChanges;
		do {
			madeChanges = false;
			for (int i = 1; i < studentList.length; i++) {
				if ((studentList[i] != null) && (studentList[i - 1] != null)) {
					if ((studentList[i - 1].getSurname() + studentList[i - 1].getName())
							.compareTo(studentList[i].getSurname() + studentList[i].getName()) > 0) {
						Student buffer = studentList[i];
						studentList[i] = studentList[i - 1];
						studentList[i - 1] = buffer;
						madeChanges = true;
					}
				}
			}
		} while (madeChanges);
	}

	public int[] findStudent(String surname) {
		int[] index = new int[studentList.length];
		int n = 0;
		for (int i = 0; i < studentList.length; i++) {
			if ((studentList[i] != null) && (studentList[i].getSurname() == surname)) {
				index[n++] = i;
			}
		}

		return Arrays.copyOf(index, n);
	}

	@Override
	public String toString() {
		groupSort();
		StringBuilder sb = new StringBuilder("-------" + name + "-------" + System.lineSeparator());
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i] != null) {
				sb.append(i + ". " + studentList[i].getSurname() + " " + studentList[i].getName()
						+ System.lineSeparator());
			}

		}
		sb.append("-------------------");
		return sb.toString();
	}

}
