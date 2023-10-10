package prac11.Ex2;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

public class LabClassUI extends JFrame {

    private ArrayList<Student> students;
    private JTable studTable;

    public LabClassUI(ArrayList<Student> students){
        // base
        super("Students");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        //setLocationRelativeTo(null);

        this.students = students;

        // Buttons
        JPanel pN = new JPanel(new FlowLayout());
        JButton addStudentBtn = new JButton("Add student");
        JButton remStudentBtn = new JButton("Delete Student");
        JButton findStudentBtn = new JButton("Find Student");

        pN.add(addStudentBtn);
        pN.add(remStudentBtn);
        pN.add(findStudentBtn);

        addStudentBtn.addActionListener(e -> {
            try {
                addBtnClicked();
            }catch (IllegalArgumentException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        remStudentBtn.addActionListener(e-> remBtnClicked());

        findStudentBtn.addActionListener(e->{
            try{
                findBtnClicked();
            }catch (StudentNotFoundException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        // JTable
        Object[] headers = new String[] {"Name", "ID", "Final Score"};
        Object [][] startStudents = new String[students.size()][3];
        for(int i = 0; i < students.size(); i++){
            startStudents[i][0] = students.get(i).getName();
            startStudents[i][1] = ((Integer)(students.get(i).getId())).toString();
            startStudents[i][2] = ((Integer)(students.get(i).getFinalScore())).toString();
        }
        studTable = new JTable( new DefaultTableModel(startStudents, headers)){
            @Override
            public boolean isCellEditable(int x, int y){
                return false;
            }
        };

        JTableHeader header = studTable.getTableHeader();
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);


        header.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int count = e.getClickCount();
                if (count == 2){
                    if(header.getHeaderRect(1).contains(e.getX(), e.getY()))
                        sortStudents(Student::compareTo);
                    if(header.getHeaderRect(2).contains(e.getX(), e.getY()))
                        sortStudents(Student.getSortingByGPA());

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        // Adding comps
        getContentPane().add(new JScrollPane(studTable), BorderLayout.CENTER);

        getContentPane().add(pN, BorderLayout.NORTH);

        setVisible(true);
    }

    private void sortStudents(Comparator<Student> comp){
        Student temp;
        for (int i = 1; i < students.size(); i++) {
            Student current = students.get(i);
            int j = i-1;
            for(; j >= 0 && comp.compare(current, students.get(j)) < 0; j--) {
                students.set(j+1, students.get(j));
            }
            students.set(j+1, current);
        }
        DefaultTableModel dtm = (DefaultTableModel) studTable.getModel();

        for (int i = 0; i < students.size(); i++) {
            dtm.removeRow(i);
            Student st = students.get(i);
            dtm.insertRow(i, new Object[]{st.getName(), st.getId(), st.getFinalScore()});
        }
    }

    private void findBtnClicked() throws StudentNotFoundException {
        String s = JOptionPane.showInputDialog("Enter name you need");
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getName().equals(s)){
                JOptionPane.showMessageDialog(this, "Find a student: "+
                        students.get(i).toString());
                return;
            }
        }
        throw new StudentNotFoundException(s);
    }

    private void remBtnClicked() {
        int c = studTable.getSelectedRowCount();
        if(c != 1) {
            JOptionPane.showMessageDialog(this, "Choose only one string!");
            return;
        }
        c = studTable.getSelectedRow();
        students.remove(c);
        DefaultTableModel dtm = (DefaultTableModel) studTable.getModel();

        dtm.removeRow(c);

    }

    private void addBtnClicked() throws IllegalArgumentException {
        String name = JOptionPane.showInputDialog("Please enter name!");
        if(name.equals("")) throw new EmptyStringException();
        String id = JOptionPane.showInputDialog("Please enter id!");
        String finalScore = JOptionPane.showInputDialog("Please enter final score!");

        int finalScoreI =0;
        int idI = 0;
        try {
            finalScoreI = Integer.parseInt(finalScore);
            idI = Integer.parseInt(id);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Impossible string "+e.getMessage().substring(17) + " to number!");
        }

        students.add(new Student(name, idI, finalScoreI));

        DefaultTableModel dtm = (DefaultTableModel) studTable.getModel();

        dtm.addRow(new Object[]{name, id, finalScore});
    }
}
