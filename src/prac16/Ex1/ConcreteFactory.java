package prac16.Ex1;

public class ConcreteFactory implements ComplexAbstarctFactory{
    @Override
    public Complex createComplex() {
        return new Complex(0,0);
    }

    @Override
    public Complex CreateComplex(int real, int image) {
        return new Complex(real, image);
    }
}
