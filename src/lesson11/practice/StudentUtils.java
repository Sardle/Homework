package lesson11.practice;

import java.util.List;

public class StudentUtils {
    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName() + " обучается на " + course + " курсе");
            }
        }
    }

    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName() + " обучается на " + student.getCourse() + " курсе");
        }
    }
}
