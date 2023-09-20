package prac6;

public class Student implements Comparable<Student> {

    private String name;
    private int id;
    private int finalScore;
    private SortingStudentsByGPA sortingByGPA = new SortingStudentsByGPA();

    public Student(String name, int id, int finalScore) {
        this.name = name;
        this.id = id;
        this.finalScore = finalScore;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public SortingStudentsByGPA getSortingByGPA() {
        return sortingByGPA;
    }

    @Override
    public int compareTo(Student student) {
        if (id == student.id) {
            return 0;
        } else if (id > student.id) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return (
                "{ name: \"" +
                        name +
                        "\", id: " +
                        id +
                        ", final-score: " +
                        finalScore +
                        " }"
        );
    }
}