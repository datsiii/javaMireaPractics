package prac16.Ex3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frame extends JFrame{
    private ICreateDocument createDocument;

    public Frame(ICreateDocument createDocument){
        super("Editor");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.createDocument = createDocument;
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        setJMenuBar(menuBar);
        setLayout(new FlowLayout());
        setSize(300, 200);
        setVisible(true);
    }
    private JMenu createFileMenu(){
        JMenu menu = new JMenu("File");
        //add(menuBar);

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem(new ExitAction());

        menu.add(newItem);
        menu.add(openItem);
        menu.add(saveItem);
        menu.add(exitItem);

        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDocument.CreateNew();
                System.out.println("Created");
            }
        });
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDocument.CreateOpen();
                System.out.println("Opened");
            }
        });
        return menu;
    }
    class ExitAction extends AbstractAction
    {
        @Serial
        private static final long serialVersionUID = 1L;
        ExitAction() {
            putValue(NAME, "Exit");
        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}

