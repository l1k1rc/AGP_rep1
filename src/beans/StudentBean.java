package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import core.Course;
import core.MockCore;
import core.Student;


@ManagedBean
@RequestScoped
public class StudentBean {
	private String currentStudentName;
	private List<Student> students = MockCore.getAllStudents();
	private List<SelectItem> items = new ArrayList<SelectItem>();
	private Map<String, Student> studentMap = new HashMap<String, Student>();
	private List<String> randomData = Arrays.asList("10.78$", "76.98$", "544.50$");

	
	
	private String passingValue;
	
	public String getPassingValue() {
		return passingValue;
	}
	public void setPassingValue(String passingValue) {
		this.passingValue = passingValue;
	}
	
	
	
	
	public StudentBean() {
		currentStudentName = students.get(0).getName();
		for (Student student : students) {
			SelectItem menuChoice = new SelectItem(student.getName());
			items.add(menuChoice);
			studentMap.put(student.getName(), student);
		}
		System.out.println(students.size());
	}
	public List<String> getRandomData() {
		System.out.println(randomData);
		return randomData;
	}
	public String getCurrentStudentName() {
		return currentStudentName;
	}

	public void setCurrentStudentName(String currentStudentName) {
		this.currentStudentName = currentStudentName;
	}

	public List<SelectItem> getItems() {
		return items;
	}
	public List<Student> getStudents(){
		return students;
	}
	public List<Course> getCourses(){
		
		System.out.println(students.get(0).getCourse());
		return students.get(0).getCourses();
	}

	public void setItems(List<SelectItem> items) {
		this.items = items;
	}

	public Student getStudent() {
		return studentMap.get(currentStudentName);
	}

}
