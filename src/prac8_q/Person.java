package prac8_q;

public class Person {
    String name;
    String surname;
    String patronymic;

    public Person(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    private StringBuffer getInitial(String word) {
        if (word != "") {
            return new StringBuffer().append(word.charAt(0)).append(".");
        }

        return new StringBuffer("");
    }

    public String getNotFullName() {
        StringBuffer temp;
        StringBuffer resBuff = new StringBuffer(surname);

        temp = getInitial(name);
        if (temp.length() != 0) {
            resBuff.append(" ").append(temp);
        }

        temp = getInitial(patronymic);
        if (temp.length() != 0) {
            if (resBuff.charAt(resBuff.length() - 1) == '.') {
                resBuff.append(temp);
            } else {
                resBuff.append(" ").append(temp);
            }
        }

        return resBuff.toString();
    }
}
