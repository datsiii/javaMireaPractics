package prac11.Ex2;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String name) {
        super("Student with name "+ name + " not found!");
    }
}
