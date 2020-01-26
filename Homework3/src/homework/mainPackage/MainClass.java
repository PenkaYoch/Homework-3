package homework.mainPackage;

import java.util.ArrayList;
import homework.extending.*;
import homework.interfaces.Adaptable;

public class MainClass {

	private static ArrayList<Person> people = new ArrayList<>();
	private static ArrayList<Student> students = new ArrayList<>();

	public static void main(String[] args) {

		people.addAll(Professor.ProfessorGenerator.create());
		people.add(Student.StudentGenerator.makeStu());
		people.add(Student.StudentGenerator.makeStu());
		RichStudent2 rich = Student.StudentGenerator.makeRichStu2();
		people.add(rich);

		showStats();
		showStatsTwo();

		try {
			Class stu = Class.forName("homework.extending.Student");
			Object newStu = stu.newInstance();
			System.out.println("The new instance of class: " + newStu.getClass().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Create anonymous class which implements \"Adaptable\": ");
		System.out.println("------------------------------------------------------------");
		createAnonymousClass();
	}

	public static void showStats() {
		int[] counts = countNumberOfType(people);
		System.out.println("------------------------------------------------------------");
		System.out.printf("Общият брой хора(от тип %s) е: %d", Person.class.getName(), counts[0]);
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.printf("Броят от тип %s е: %d", Student.class.getName(), counts[1]);
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.printf("Броят от тип %s е: %d", Professor.class.getName(), counts[2]);
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.printf("Броят от тип %s е: %d", RichStudent2.class, counts[3]);
		System.out.println();
		System.out.println("------------------------------------------------------------");
	}

	public static void showStatsTwo() {
		System.out.println("------------------------------------------------------------");
		System.out.println("Calling of \"study()\" method of Student and RichStudent:");
		System.out.println("------------------------------------------------------------");
		for (Student s : students) {
			s.study();
		}
	}

	public static int[] countNumberOfType(ArrayList<Person> allPeople) {
		int allCount = 0;
		int stuCount = 0;
		int profCount = 0;
		int richStu2Count = 0;

		for (Person p : allPeople) {
			allCount++;
			if (p.getClass().equals(Student.class)) {
				students.add((Student) p);
				stuCount++;
			} else if (p.getClass().equals(Professor.class)) {
				profCount++;
			} else if (p.getClass().equals(RichStudent2.class)) {
				students.add((RichStudent2) p);
				richStu2Count++;
			}
		}
		int[] counts = { allCount, stuCount, profCount, richStu2Count };
		return counts;
	}

	public static void createAnonymousClass() {
		class AnonymousClass implements Adaptable {

			public void study() {
				System.out.println("The anonymous student study hard.");
			}

			public void think() {
				System.out.println("The anonymous student think fast.");
			}

			@Override
			public void act() {
				System.out.println("The anonymous student act fast.");
			}
		};
		
		AnonymousClass obj = new AnonymousClass();
		obj.study();
		obj.act();
		obj.think();
	}
}
