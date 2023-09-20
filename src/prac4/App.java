package prac4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame {

    Font fnt = new Font("Comic Sans", Font.ITALIC, 20);
    Font fntn = new Font("Comic Sans", Font.BOLD, 15);
    JButton btnMilan = new JButton("AC Milan");
    JButton btnMadrid = new JButton("Real Madrid");
    JLabel currentScore = new JLabel("Result: 0 X 0");
    JLabel lastScorer = new JLabel("Last Scorer: N/A");
    JLabel winner = new JLabel("Winner: DRAW");

    int firstTeamScore = 0;
    int secondTeamScore = 0;

    App() {
        super("App");
        setLayout(new FlowLayout());
        setSize(500, 100);
        setVisible(true);
        btnMadrid.setFont(fnt);
        btnMilan.setFont(fnt);
        currentScore.setFont(fntn);
        lastScorer.setFont(fntn);
        winner.setFont(fntn);

        add(btnMilan);
        add(btnMadrid);

        btnMilan.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        firstTeamScore++;
                        currentScore.setText(
                                "Result: " + firstTeamScore + " X " + secondTeamScore
                        );
                        lastScorer.setText("Last Scorer: AC Milan");
                        if (firstTeamScore > secondTeamScore) {
                            winner.setText("Winner: AC Milan");
                        } else if (firstTeamScore == secondTeamScore) {
                            winner.setText("Winner: DRAW");
                        }
                    }

                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub

                    }
                }
        );

        btnMadrid.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        secondTeamScore++;
                        currentScore.setText(
                                "Result: " + firstTeamScore + " X " + secondTeamScore
                        );
                        lastScorer.setText("Last Scorer: Real Madrid");
                        if (secondTeamScore > firstTeamScore) {
                            winner.setText("Winner: Real Madrid");
                        } else if (firstTeamScore == secondTeamScore) {
                            winner.setText("Winner: DRAW");
                        }
                    }

                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {
                        // TODO Auto-generated method stub

                    }
                }
        );

        //add(btnMadrid);
        add(currentScore);
        add(lastScorer);
        add(winner);
    }

    public static void main(String[] args) {
        new App();
    }
}
