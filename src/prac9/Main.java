package prac9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
        view.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = view.getEmployeeName();
            double hourlyRate = view.getHourlyRate();
            int hoursWorked = view.getHoursWorked();

            model = new Employee(name, hourlyRate, hoursWorked);
            double salary = model.calculateSalary();
            System.out.printf("%s, salary: %s",model, salary);
            view.setSalary(salary);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee model = new Employee("", 0, 0);
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);
    }
}


class EmployeeView {
    private JFrame frame;
    private JLabel nameLabel;
    private JLabel rateLabel;
    private JLabel hoursLabel;
    private JLabel salaryLabel;
    private JButton calculateButton;

    public EmployeeView() {
        frame = new JFrame("Employee Salary Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);

        nameLabel = new JLabel("Name: ");
        rateLabel = new JLabel("Hourly Rate: ");
        hoursLabel = new JLabel("Hours Worked: ");
        salaryLabel = new JLabel("Salary: ");
        calculateButton = new JButton("Calculate");

        panel.add(nameLabel);
        panel.add(rateLabel);
        panel.add(hoursLabel);
        panel.add(salaryLabel);
        panel.add(calculateButton);

        frame.setVisible(true);
    }

    public String getEmployeeName() {
        return JOptionPane.showInputDialog("Enter employee name:");
    }

    public double getHourlyRate() {
        String rateStr = JOptionPane.showInputDialog("Enter hourly rate:");
        return Double.parseDouble(rateStr);
    }

    public int getHoursWorked() {
        String hoursStr = JOptionPane.showInputDialog("Enter hours worked:");
        return Integer.parseInt(hoursStr);
    }

    public void setSalary(double salary) {
        salaryLabel.setText("Salary: " + salary);
    }

    public void addCalculateListener(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }
}

class Employee {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public Employee(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", hourlyRate=").append(hourlyRate);
        sb.append(", hoursWorked=").append(hoursWorked);
        sb.append('}');
        return sb.toString();
    }
}
