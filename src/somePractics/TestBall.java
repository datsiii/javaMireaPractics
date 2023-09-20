package somePractics;

import somePractics.Ball;

import java.lang.*;

public class TestBall {
    public static void main(String[] args) {
        Ball ball1 = new Ball("yellow", 5);
        Ball ball2 = new Ball("red");
        Ball ball3 = new Ball();

        ball2.setRadius(10);
        ball3.setColor("orange");
        ball3.setRadius(15);

        System.out.println(ball1);
        System.out.println(ball2);
        System.out.println(ball3);

        ball1.getVolume();
        ball2.getVolume();
        ball3.getVolume();
    }
}
