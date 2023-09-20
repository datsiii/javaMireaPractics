package prac3_ex1;

public class Square extends Rectangle{
    public Square() {
        super(2, 2);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return this.width;
    }

    public void setSide(double side) {
        setWidth(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public void setLength(double side) {
        setWidth(side);
    }

    @Override
    public String toString() {
        return "Shape: square, side: " + this.width + ", color: "+ this.color;
    }
}
