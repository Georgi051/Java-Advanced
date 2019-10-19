package FilesAndStreams.exersice;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String mainPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputPath = mainPath + "\\inputOne.txt";
        String secondPath = mainPath + "\\inputTwo.txt";
        String output = mainPath + "\\output.txt";

        PrintWriter pWriter = new PrintWriter(new FileWriter(output));
        BufferedReader inputOne = null;
        BufferedReader inputTwo = null;
        try {
            inputOne = Files.newBufferedReader(Paths.get(inputPath));
            inputTwo = Files.newBufferedReader(Paths.get(secondPath));

            String lineOne = inputOne.readLine();
            while (lineOne != null){
                pWriter.println(lineOne);
                lineOne = inputOne.readLine();
            }

            String lineTwo = inputTwo.readLine();
            while (lineTwo != null){
                pWriter.println(lineTwo);
                lineTwo = inputTwo.readLine();
            }
            pWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputOne != null){
                inputOne.close();
            }
            if (inputTwo != null){
                inputTwo.close();
            }
        }
    }
}
