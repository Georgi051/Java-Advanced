package FilesAndStreams.exersice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        String mainPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";

        String inputPath = mainPath + "\\input.txt";
        String outputPath = mainPath + "\\output.txt";
        BufferedReader bReader = null;
        PrintWriter pWriter = null;
        try {
            bReader = Files.newBufferedReader(Paths.get(inputPath));
            pWriter = new PrintWriter(new FileWriter(outputPath));
            int oneByte = bReader.read();
            while (oneByte >= 0){
                pWriter.write(Character.toUpperCase(oneByte));
                oneByte = bReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bReader != null){
                bReader.close();
            }
            if (pWriter != null){
                pWriter.close();
            }
        }
    }
}
