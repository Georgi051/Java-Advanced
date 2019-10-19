package FilesAndStreams.exersice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {

        String mainPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";

        String inputPath = mainPath + "\\input.txt";

        try {
            BufferedReader bReader = Files.newBufferedReader(Paths.get(inputPath));
            String oneByte = bReader.readLine();
            while (oneByte != null){
                long sum = 0;
                for (char c : oneByte.toCharArray()) {
                    sum += c;
                }
                oneByte = bReader.readLine();
                System.out.println(sum);
            }
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
