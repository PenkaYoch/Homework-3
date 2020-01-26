package homework.tests;

import homework.extending.RichStudent2;

public class RichStudent2Test {
	
	public static void specialityTest(RichStudent2 student) {
		String specExpected = "STD";
		String specResult = student.getSpeciality();
		
		if (assertString(specResult, specExpected)) {
			System.out.println("Method getSpecility() from RichStudent2 class returns what is expected");
		} else {
			System.err.println(
					"Method getSpecility() from class RichStudent2 returns: " +
					specResult + ", but the expected result is: " +
					specExpected
			);
		}
	}
	
	public static boolean assertString(String result, String expectedResult) {
		return result.equals(expectedResult);
	}
}
