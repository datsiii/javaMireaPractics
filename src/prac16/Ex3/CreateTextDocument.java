package prac16.Ex3;

public class CreateTextDocument implements ICreateDocument{
    @Override
    public IDocument CreateNew() {
        System.out.println("New text document");
        return new TextDocument();
    }

    @Override
    public IDocument CreateOpen() {
        System.out.println("Open text document");
        return new TextDocument();
    }
}
