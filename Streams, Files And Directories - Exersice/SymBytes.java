package FilesAndStreams.exersice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SymBytes {
    public static void main(String[] args) {
        String mainPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";

        String inputPath = mainPath + "\\input.txt";

        try {
            BufferedReader bReader = Files.newBufferedReader(Paths.get(inputPath));
            String oneByte = bReader.readLine();
            long sum = 0;
            while (oneByte != null){
                for (char c : oneByte.toCharArray()) {
                    if (c != '\n'){
                        sum += c;
                    }
                }
                oneByte = bReader.readLine();
            }
            System.out.println(sum);
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
