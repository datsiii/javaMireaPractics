package prac6;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getFinalScore() == s2.getFinalScore()) {
            return 0;
        } else if (s1.getFinalScore() > s2.getFinalScore()) {
            return -1;
        } else {
            return 1;
        }

    }
}
