package net.ukr.just_void;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Group gr = new Group("Gr401"); //группа

		Student martinJ = new Student("Jake", "Martin", Sex.Male, 22, 4, 92.5);
		Student reedD = new Student("Derek", "Reed", Sex.Male, 22, 5, 96);
		Student sarahP = new Student("Sarah", "Patrick", Sex.Female, 21, 4, 78.7);
		Student GreenM = new Student("Mick", "Green", Sex.Male, 21, 4, 68.2);
		Student hillM = new Student("Mary", "Hill", Sex.Female, 21, 4, 90.1);
		Student markV = new Student("Mark", "Vince", Sex.Male, 23, 4, 62);
		Student derekP = new Student("Derek", "Peterson", Sex.Male, 22, 4, 76.5);
		Student annaM = new Student("Anna", "Ming", Sex.Female, 21, 4, 61.8);
		Student jakeS = new Student("Jake", "Shade", Sex.Male, 23, 4, 100);
		Student mannyB = new Student("Manny", "Boyde", Sex.Female, 21, 4, 84.1);
		Student hillB = new Student("Barbara", "Hill", Sex.Female, 21, 4, 99.6);
		System.out.println("An example of Stuent info: " + System.lineSeparator() + martinJ.toString());
		System.out.println("-------");
		System.out.println("Now adding students to group...");
		Student[] students = { martinJ, martinJ, reedD, sarahP, GreenM, hillM, markV, derekP, annaM, jakeS, hillB,
				mannyB };

		for (Student i : students) {
			try {
				gr.addStudent(i);
			} catch (GroupFullException e) {
				e.printStackTrace();
			} catch (DuplicateStudentException e) {
				e.printStackTrace();
			}

		}
		System.out.println("-------");
		System.out.println("Now searchign for a student in the group...");

		System.out.println(
				"Indexi of students with surnames \"Hill\" in the group: " + Arrays.toString(gr.findStudent("Hill")));
		System.out.println("-------");
		System.out.println("Now listing all students...");		
		System.out.println(gr.toString());
		System.out.println("Now deleting students...");
		gr.deleteStudent(1);
		gr.deleteStudent(mannyB);
		gr.deleteStudent(annaM);
		System.out.println("-------");
		System.out.println("Now listing all students...");
		System.out.println(gr.toString());

	}

}
