package prac11.Ex2;

public class EmptyStringException extends IllegalArgumentException {
    public EmptyStringException() {
        super("Get empty string!");
    }
}
