package core;

public class Course {
    private String name;
    private double score;

    public Course() {
    }

    public Course(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }
 
    public void setScore(double score) {
        this.score = score;
    }
}
