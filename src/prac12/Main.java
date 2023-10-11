package prac12;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Animal{}
class Test extends Animal implements Serializable {}
public class Main{
    public static void main(String[] args){
      /*  String s = "qwe";
        Test t = new Test();
        Double q = 1.2;
        MyClass<String,Test, Double> A = new MyClass<>(s, t, q);
        A.printClassNames();*/

        /*
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2 ,3));
        MinMax<Integer> A = new MinMax(list);
        System.out.println(A.findMax() + " " + A.findMin());*/

        int a = 5;
        double b = 2.5;
        System.out.println("Sum: " + Calculator.sum(a, b));
        System.out.println("Multiply: " + Calculator.multiply(a, b));
        System.out.println("Divide: " + Calculator.divide(a, b));
        System.out.println("Subtract: " + Calculator.subtract(a, b));
    }


}

class MyClass<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private final T argT;
    private final V argV;
    private final K argK;

    public void printClassNames() {
        System.out.println("Type of T: " + argT.getClass().getName());
        System.out.println("Type of V: " + argV.getClass().getName());
        System.out.println("Type of K: " + argK.getClass().getName());
    }

    public  MyClass(T t, V v, K k){
        this.argT = t;
        this.argV = v;
        this.argK = k;
    }

    public T getArgT() {
        return argT;
    }

    public V getArgV() {
        return argV;
    }

    public K getArgK() {
        return argK;
    }
}

class MinMax<E extends Comparable<E>>{
    private ArrayList<E> array;
    private int a;
    public MinMax(ArrayList<E> list){
        this.array = list;
    }

    public E findMin(){
        E min = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            E current = array.get(i);
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }
        return min;
    }
    public E findMax(){
        E max = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            E current = array.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

}

class Calculator {
    public static <T extends Number, U extends Number> double sum(T num1, U num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T num1, U num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T num1, U num2) {
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double subtract(T num1, U num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}

class CalculatorGUI {
    private JFrame frame;
    private JTextField inputField;
    private JButton addButton, multiplyButton, divideButton, subtractButton;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        inputField.setHorizontalAlignment(JTextField.RIGHT);

        addButton = new JButton("+");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        subtractButton = new JButton("-");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(subtractButton);

        addButton.addActionListener(new OperationListener('+'));
        multiplyButton.addActionListener(new OperationListener('*'));
        divideButton.addActionListener(new OperationListener('/'));
        subtractButton.addActionListener(new OperationListener('-'));

        frame.setLayout(new BorderLayout());
        frame.add(inputField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private class OperationListener implements ActionListener {
        private char operation;

        public OperationListener(char operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(inputField.getText());
                double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter second number:"));
                double result = 0;
                switch (operation) {
                    case '+':
                        result = Calculator.sum(num1, num2);
                        break;
                    case '*':
                        result = Calculator.multiply(num1, num2);
                        break;
                    case '/':
                        result = Calculator.divide(num1, num2);
                        break;
                    case '-':
                        result = Calculator.subtract(num1, num2);
                        break;
                }
                inputField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}

class Matrix<T extends Number> {
    private T[][] data;

    public Matrix(T[][] data) {
        this.data = data;
    }

    public Matrix<T> add(Matrix<T> other) {
        if (data.length != other.data.length || data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Матрицы имеют разные размеры");
        }

        T[][] result = (T[][]) new Number[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result[i][j] = addElements(data[i][j], other.data[i][j]);
            }
        }

        return new Matrix<>(result);
    }

    public Matrix<T> subtract(Matrix<T> other) {
        if (data.length != other.data.length || data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Матрицы имеют разные размеры");
        }

        T[][] result = (T[][]) new Number[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result[i][j] = subtractElements(data[i][j], other.data[i][j]);
            }
        }

        return new Matrix<>(result);
    }

    public Matrix<T> multiplyByScalar(T scalar) {
        T[][] result = (T[][]) new Number[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result[i][j] = multiplyElements(data[i][j], scalar);
            }
        }

        return new Matrix<>(result);
    }

    private T addElements(T a, T b) {
        return (T) (Number) (a.doubleValue() + b.doubleValue());
    }

    private T subtractElements(T a, T b) {
        return (T) (Number) (a.doubleValue() - b.doubleValue());
    }

    private T multiplyElements(T a, T b) {
        return (T) (Number) (a.doubleValue() * b.doubleValue());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T[] row : data) {
            for (T element : row) {
                sb.append(element).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[][] data1 = {{1, 2}, {3, 4}};
        Integer[][] data2 = {{5, 6}, {7, 8}};

        Matrix<Integer> matrix1 = new Matrix<>(data1);
        Matrix<Integer> matrix2 = new Matrix<>(data2);

        Matrix<Integer> sum = matrix1.add(matrix2);
        Matrix<Integer> difference = matrix1.subtract(matrix2);
        Matrix<Integer> scaled = matrix1.multiplyByScalar(2);

        System.out.println("Matrix1:");
        System.out.println(matrix1);

        System.out.println("Matrix2:");
        System.out.println(matrix2);

        System.out.println("Sum:");
        System.out.println(sum);

        System.out.println("Difference:");
        System.out.println(difference);

        System.out.println("Scaled:");
        System.out.println(scaled);
    }
}
