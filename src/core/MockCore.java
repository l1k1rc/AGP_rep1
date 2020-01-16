package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import persistence.jdbc.HotelPersistence;

/**
 * A utility class for providing data simulation (act as a simple database).
 * 
 */
public class MockCore {
	private static final Map<String, String> userRegistry = new HashMap<String, String>();
	static {
		userRegistry.put("user1", "aaa");
		userRegistry.put("user2", "bbb");
	}

	private static final List<Course> coursesJean = new ArrayList<Course>();
	static {
		coursesJean.add(new Course("Java programming", 17));
		coursesJean.add(new Course("C programming", 16));
	}

	private static final List<Course> coursesLuc = new ArrayList<Course>();
	static {
		coursesLuc.add(new Course("Databases", 16));
		coursesLuc.add(new Course("Artificial Intelligence", 15));
		coursesLuc.add(new Course("Embedded System", 16));
	}

	private static final List<Student> students = new ArrayList<Student>();
	static {
		Student chris = new Student();
		chris.setName("Chris");
		chris.setNumber(0000111);
		chris.setCourses(coursesLuc);
		students.add(chris);
		Student jean = new Student();
		jean.setName("Jean");
		jean.setNumber(21111111);
		jean.setCourses(coursesJean);
		students.add(jean);

		Student luc = new Student();
		luc.setName("Luc");
		luc.setNumber(21111112);
		luc.setCourses(coursesLuc);
		students.add(luc);
	}

	public static boolean exist(String login) {
		return userRegistry.containsKey(login);
	}

	public static boolean isValid(String login, String password) {
		boolean result = false;
		if (userRegistry.containsKey(login)) {
			String expectedPassword = userRegistry.get(login);
			if (expectedPassword.equals(password)) {
				result = true;
			}
		}
		return result;
	}

	public static Student getStudent() {
		Student student = new Student();
		student.setName("Jean");
		student.setNumber(21111111);
		student.setCourses(coursesJean);
		Student student2 = new Student();
		student2.setName("Patrik");
		student2.setNumber(21111111);
		student2.setCourses(coursesLuc);
		return student;
	}
	private static List<Hotel> hotelFound = new ArrayList<Hotel>();
	static {
		hotelFound = HotelPersistence.operatorSQL("SELECT * FROM hotel WHERE quality=3");
	}
	public static List<Student> getAllStudents() {
		return students;
	}

	public static List<Hotel> getHotelFound() {
		System.out.println("Get hotel found by request");
		return hotelFound;
	}

	

}
