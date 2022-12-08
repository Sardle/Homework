package lesson11.practice;

public class Student {
    private String name;
    private String nameGroup;
    private double evaluation;
    private int course;

    public double getEvaluation() {
        return evaluation;
    }

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Student(String name, String nameGroup, double evaluation, int course) {
        this.name = name;
        this.nameGroup = nameGroup;
        this.evaluation = evaluation;
        this.course = course;
    }

    public boolean upCourse() {
        if (getEvaluation() >= 3) {
            setCourse(getCourse() + 1);
            return true;
        } else {
            return false;
        }
    }
}
