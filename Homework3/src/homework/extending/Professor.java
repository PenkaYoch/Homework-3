package homework.extending;

import java.util.ArrayList;
import java.util.Calendar;

import homework.extending.Professor;

public class Professor extends Person {

	private String title;
	
	public Professor() {
		
	}
	
	public Professor(String title, String name, boolean isMale, 
					 int age, int height, int weight) {
		super(name, isMale, age, height, weight);
		this.title = title;
	}
	
	@Override
	public String toString() {
		return String.format("The professor %s is with title %s", 
							 this.getName(), this.getTitle());
	}

	// �?мплементация на абстрактен метод
	@Override
	protected String getTypicalDrink() {
		return "Water with lemon";
	}

	// Пренаписване на метод от супер клас
	@Override
	public void goBar() {
		super.goBar();
		System.out.println("After second drink the Professor have a good mood!"
				+ "");
	}

	// �?мплементация на методите от двата интерфейса (без getShower(), който е
	// имплементиран в абстрактният клас. Ако е необходимо getShower() може да се пренапише)
	@Override
	public void getUpEarly(Calendar hour) {
		System.out.println("The professor usually gets up at" + hour);
	}

	@Override
	public void run(int minutes) {
		// TODO Auto-generated method stub
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
	}

	@Override
	public void think() {
		// TODO Auto-generated method stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
	}

	// Getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public static class ProfessorGenerator {
		private static String[] titles = {"проф.", "доц. д-р"};
		private static String[] names = {"Иван", "Мария"};
		private static Boolean[] isMale = {true, false};
		private static Integer[] age = {42, 37};
		private static Integer[] height = {178, 165};
		private static Integer[] weight = {85, 60};
		
		public static ArrayList<Professor> create() {
			ArrayList<Professor> profs = new ArrayList<Professor>();
			for(int i = 0; i < names.length; i++) {
				profs.add(new Professor(titles[i], names[i], isMale[i], age[i], height[i], weight[i]));
			}
			return profs;
		}
	}
}
