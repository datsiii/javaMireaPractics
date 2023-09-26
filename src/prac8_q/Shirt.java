package prac8_q;

public class Shirt {
    String name;
    String color;
    String size;
    String id;

    public Shirt(String name, String color, String size, String id) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.id = id;
    }

    public static Shirt fromString(String str) {
        String[] arr = str.split(",");
        return new Shirt(arr[1], arr[2], arr[3], arr[0]);
    }

    @Override
    public String toString() {
        return new StringBuffer()
                .append("{ name: \"")
                .append(name)
                .append("\", color: \"")
                .append(color)
                .append("\", size: \"")
                .append(size)
                .append("\", id: \"")
                .append(id)
                .append("\" }")
                .toString();
    }
}
