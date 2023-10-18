package prac13.Ex3;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Files {
    ArrayList<String> files;

    public void listFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        String[] files = directory.list();
        this.files = new ArrayList<String>();
        this.files.addAll(Arrays.asList(files));
    }

    public List<String> getFifthEl() {
        return files.subList(0, 5);
    }

}

