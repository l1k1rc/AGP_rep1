package core;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int number;
    private List<Course> courses = new ArrayList<Course>();

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }
    public String getCourse() {
    	System.out.println(courses.get(0).getName());
    	return courses.get(0).getName();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
