package prac9;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MVCPatternDemo {
    public static void main(String[] args) {
        Student student = retrieveStudentFromDatabase();

        StudentVIew view= new StudentVIew();

        StudentController controller = new StudentController(student, view);
        controller.updateView();

        controller.setStudentName("Python");
        controller.setStudentRollNo("New rollNo");
        System.out.println();
        controller.updateView();
    }
    static Student retrieveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Java");
        student.setRollNo("Programming");
        return student;
    }
}

class StudentVIew{
    void printStudentDetails(String rollNo, String name){
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("rollNo='").append(rollNo).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        System.out.println(sb);
    }
}

class Student{
    String rollNo;
    String name;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class StudentController{
    Student model;
    StudentVIew view;

    StudentController(Student model, StudentVIew view){
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name){
        model.setName(name);
    }

    public void setStudentRollNo(String rollNo){
        model.setRollNo(rollNo);
    }

    public String getStudentName(){
        return model.getName();
    }

    public String getStudentRollNo(){
        return model.getRollNo();
    }

    void updateView(){
        view.printStudentDetails(model.getRollNo(), model.getName());
    }
}

