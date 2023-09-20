package prac3_ex2;

public class MovableTest{
    public static void exec() {
        MovablePoint point1 = new MovablePoint(3, 0, 10, 20);
        System.out.println(point1);
        point1.moveDown();
        point1.moveRight();
        System.out.println(point1);

        MovableCircle circle1 = new MovableCircle(3, 0, 10, 20, 100);
        System.out.println(circle1);
        circle1.moveLeft();
        circle1.moveDown();
        System.out.println(circle1);

        MovableRectangle rectangle1 = new MovableRectangle(0, 0, 15, 3, 23, 42);
        System.out.println(rectangle1);
        rectangle1.moveUp();
        rectangle1.moveRight();
        System.out.println(rectangle1);
    }

}
