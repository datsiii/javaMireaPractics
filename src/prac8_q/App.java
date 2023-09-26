package prac8_q;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import prac8_q.FormattingString.FormattingType;
public class App {
    public static void main(String[] args) {

        //EX 1-2
        Person me = new Person("", "Tsivina", "D");
        System.out.println("-----------------------EX 1-2------------------------------------");
        System.out.println(me.getNotFullName());






        System.out.println("------------------------EX 3------------------------------------");
        Address address = new Address();

        address.separate(
                "COUNTRY, REGION, CITY, STREET, HOUSE, BUILDING, APARTMENT"
        );
        System.out.println(address);

        address.separate(
                "COUNTRY, REGION: CITY, STREET. HOUSE- BUILDING/ APARTMENT"
        );
        System.out.println(address);







        System.out.println("------------------------EX 4-------------------------------------");
        String[] shirtsStr = new String[11];
        shirtsStr[0] = "S001,Black Polo Shirt,Black,XL";
        shirtsStr[1] = "S002,Black Polo Shirt,Black,L";
        shirtsStr[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirtsStr[3] = "S004,Blue Polo Shirt,Blue,M";
        shirtsStr[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirtsStr[5] = "S006,Black T-Shirt,Black,XL";
        shirtsStr[6] = "S007,White T-Shirt,White,XL";
        shirtsStr[7] = "S008,White T-Shirt,White,L";
        shirtsStr[8] = "S009,Green T-Shirt,Green,S";
        shirtsStr[9] = "S010,Orange T-Shirt,Orange,S";
        shirtsStr[10] = "S011,Maroon Polo Shirt,Maroon,S";

        Shirt[] shirts = new Shirt[11];
        for (int i = 0; i < shirtsStr.length; i++) {
            shirts[i] = Shirt.fromString(shirtsStr[i]);
        }

        for (Shirt shirt : shirts) {
            System.out.println(shirt);
        }






        System.out.println("------------------------EX 5-------------------------------------");
        System.out.println(new Phone("+71234567890").formattedPhone);
        System.out.println(new Phone("81234567890").formattedPhone);
        System.out.println(new Phone("+101234567890").formattedPhone);





        System.out.println("------------------------EX 6-------------------------------------");
        Scanner consoleScanner = new Scanner(System.in);
        String fileName = consoleScanner.nextLine();
        consoleScanner.close();

        try (FileReader fileReader = new FileReader(fileName)) {
            Scanner fileScanner = new Scanner(fileReader);
            String str = fileScanner.nextLine();
            fileScanner.close();

            str = getLine(str);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLine(String str) {
        ArrayList<String> words = new ArrayList<>(List.of(str.split(" ")));
        StringBuilder sb = new StringBuilder();

        FormattingString res = new FormattingString();
        if (words.size() != 0) {
            for (int i = 0; i < words.size(); i++) {
                res = getLine(sb, words, i);

                if (res.type == FormattingType.SUCCESS) {
                    return sb.toString();
                }

                if (i != words.size() - 1) {
                    sb = new StringBuilder();
                } else {
                    return sb.toString();
                }
            }
        }

        return sb.toString();
    }

    public static FormattingString getLine(
            StringBuilder sb,
            ArrayList<String> words,
            int index
    ) {
        ArrayList<String> wordsCopy = (ArrayList<String>) words.clone();
        sb.append(wordsCopy.get(index));
        wordsCopy.remove(index);

        int counter = 0;
        while (wordsCopy.size() != 0) {
            for (int i = 0; i < wordsCopy.size(); i++) {
                if (addWord(sb, wordsCopy.get(i))) {
                    wordsCopy.remove(i);
                }
                counter++;
            }

            if (counter == wordsCopy.size() && wordsCopy.size() != 0) {
                sb.append(" - [Unused words]:");
                for (String word : wordsCopy) {
                    sb.append(" ").append(word);
                }
                return new FormattingString(FormattingType.ERROR, sb);
            }

            counter = 0;
        }

        return new FormattingString(FormattingType.SUCCESS, sb);
    }

    public static boolean addWord(StringBuilder sb, String word) {
        if (sb.charAt(sb.length() - 1) == word.charAt(0)) {
            sb.append(" ").append(word);
            return true;
        }

        return false;
    }
}
