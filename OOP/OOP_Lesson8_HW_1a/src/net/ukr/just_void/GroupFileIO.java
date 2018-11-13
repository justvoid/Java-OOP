package net.ukr.just_void;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GroupFileIO implements GroupDAO {

	@Override
	public void saveGroup(Group g) throws IOException {
		try {
			stringToFile(new File(g.getName() + ".txt"), generateStringFromGroup(g));
		} catch (IOException e) {
			throw e;
		}
	}

	private String generateStringFromGroup(Group g) {
		StringBuilder sb = new StringBuilder();
		for (Student st : g.getStudentList()) {
			if (st != null) {
				sb.append(studentToString(st));
			}
		}
		return sb.toString();
	}

	private String studentToString(Student st) {
		StringBuilder sb = new StringBuilder();
		sb.append(st.getName() + " ");
		sb.append(st.getSurname() + " ");
		sb.append(st.getSex() + " ");
		sb.append(st.getAge() + " ");
		sb.append(st.getYear() + " ");
		sb.append(st.getAverageGrade());
		sb.append(System.lineSeparator());
		return sb.toString();
	}

	private void stringToFile(File file, String str) throws IOException {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.print(str);
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public Group loadGroup(String name) throws IOException {
		Student[] studentList = new Student[10];
		try {
			String[] str = ReadStringFromFile(name).split(System.lineSeparator());
			for (int i = 0; (i < str.length) && (i < 10); i++) {
				studentList[i] = ReadStudentFromString(str[i]);
			}
		} catch (IOException e) {
			throw e;
		}
		return new Group(name, studentList);
	}

	private String ReadStringFromFile(String groupName) throws IOException {
		String str;
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(groupName + ".txt")))) {
			while (((str = br.readLine()) != null) && (str.length() > 0)) {
				sb.append(str + System.lineSeparator());
			}
		} catch (IOException e) {
			throw e;
		}
		return sb.toString();
	}

	private Student ReadStudentFromString(String str) {
		String[] strArray = str.split(" ");
		String name, surname;
		Sex sex;
		int age, year;
		double averageGrade;

		name = strArray[0];
		surname = strArray[1];
		sex = Sex.valueOf(strArray[2]);
		age = Integer.parseInt(strArray[3]);
		year = Integer.parseInt(strArray[4]);
		averageGrade = Double.parseDouble(strArray[5]);
		return new Student(name, surname, sex, age, year, averageGrade);
	}

}
