package core;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import beans.EntryBean;
import lucene.LuceneTester;

public class Student {
    private String name;
    private int number;
    private List<Course> courses = new ArrayList<Course>();

	public Student() {
    }
    public static void displayTest(String test) {
    	System.out.println(test);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
    	LuceneTester luceneTester = new LuceneTester();
        this.name = name;
    }

    public int getNumber() {
        return number;
    }
    public String getCourse() {
    	//System.out.println(courses.get(0).getName());
    	return courses.get(0).getName();
    }
    
    public void setNumber(int number) {
        this.number = number;
    }

    public List<Course> getCourses() {
    	System.out.println(courses);
        return courses;
    }
    
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
