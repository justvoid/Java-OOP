package net.ukr.just_void;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

	public static void main(String[] args) {
		Group gr = new Group("Gr401");
		populateGroup(gr);
		try (ServerSocket ss = new ServerSocket(8087)) {
			for (;;) {
				ClientSocket client = new ClientSocket(ss.accept(), gr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static void populateGroup(Group group) {
		Student martinJ = new Student("Jake", "Martin", Sex.Male, 22, 4, 92.5);
		Student reedD = new Student("Derek", "Reed", Sex.Male, 22, 5, 96);
		Student sarahP = new Student("Sarah", "Patrick", Sex.Female, 21, 4, 78.7);
		Student GreenM = new Student("Mick", "Green", Sex.Male, 21, 4, 68.2);
		Student hillM = new Student("Mary", "Hill", Sex.Female, 21, 4, 90.1);
		Student markV = new Student("Mark", "Vince", Sex.Male, 23, 4, 62);
		Student derekP = new Student("Derek", "Peterson", Sex.Male, 22, 4, 76.5);
		Student annaM = new Student("Anna", "Ming", Sex.Female, 21, 4, 61.8);
		Student jakeS = new Student("Jake", "Shade", Sex.Male, 23, 4, 100);
		Student hillB = new Student("Barbara", "Hill", Sex.Female, 21, 4, 99.6);
		Student[] students = { martinJ, reedD, sarahP, GreenM, hillM, markV, derekP, annaM, jakeS, hillB };

		for (Student i : students) {
			group.addStudent(i);
		}
	}

}
