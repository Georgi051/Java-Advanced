package FilesAndStreams;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String outputPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = null;
        FileWriter writer  = null;
        try {
            scanner = new Scanner(new FileInputStream(inputPath));
            writer = new FileWriter(outputPath);
            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    writer.write(String.valueOf(scanner.nextInt()));
                    writer.write('\n');
                }
                scanner.next();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (scanner != null){
                scanner.close();
            }
            if (writer != null){
                writer.close();
            }
        }
    }
}
