package utilisateur_trice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextReader {

    public static String[] readText(String path) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner sc = new Scanner(new File(path));
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            // 清除前后空格
            line = line.trim();
            if(!line.isEmpty()) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[0]);
    }

    public static void main(String[] args) {
        try {
            String[] strs = TextReader.readText("/Users/yangkai/Documents/Codes/Projects/yang_yang_java/Data/exemple1.txt");
            for (String s : strs) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
