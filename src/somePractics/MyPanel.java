package somePractics;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private String text;
    public void someAction() {
        text = "Привет!";
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        g.drawString(text, 10, 10);
    }

    public static void main(String[] args) {
        MyPanel sm = new MyPanel();
        sm.someAction();
    }
}

