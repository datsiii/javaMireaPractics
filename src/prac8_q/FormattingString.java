package prac8_q;

public class FormattingString {

    public enum FormattingType {
        ERROR,
        SUCCESS,
    }

    public FormattingType type;
    public StringBuilder res;

    public FormattingString(FormattingType type, StringBuilder res) {
        this.type = type;
        this.res = res;
    }

    public FormattingString() {}
}
