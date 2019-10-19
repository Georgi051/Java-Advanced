package FilesAndStreams.exersice;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String mainPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";

        String inputPath = mainPath + "\\inputLineNumbers.txt";
        String outputPath = mainPath + "\\output.txt";
        BufferedReader bReader = null;
        PrintWriter pWriter = null;
        try {
            bReader = Files.newBufferedReader(Paths.get(inputPath));
            pWriter = new PrintWriter(new FileWriter(outputPath));
            String line = bReader.readLine();
            int i = 1;
            while (line != null){
                pWriter.printf(String.format("%d. %s",i++,line));
                line = bReader.readLine();
                if (line != null){
                    pWriter.println();
                }
            }
            pWriter.close();
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
