package homework.extending;

import java.util.concurrent.ThreadLocalRandom;

import homework.interfaces.Adaptable;

public class RichStudent2 extends Student {
	
	public RichStudent2(){
		
	}
	
	public RichStudent2(String name, int egn, String university, String speciality, int facNumber) {
		super(name, egn, university, speciality, facNumber);
	}
	
	@Override
	public String getTypicalDrink() {
		return "50 years Black Johny";
	}
	
	@Override
	public String getSpeciality() {
		return "Informatics";
	}
	
	@Override 
	public void study() {
		System.out.println("The Rich student is studying");
	}

}
