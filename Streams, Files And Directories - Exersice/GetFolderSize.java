package FilesAndStreams.exersice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        String mainPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";

        String inputPath = mainPath + "\\Exercises Resources";
        String outputPath = mainPath + "\\output.txt";

        File file = new File(inputPath);
        long size = 0;
        try {
            for (File currentFile : file.listFiles()) {
                size += currentFile.length();
            }
        }catch (NullPointerException e){
            System.out.println("NullPointerException");
        }
        PrintWriter pWriter = new PrintWriter(new FileWriter(outputPath));
        pWriter.printf("Folder size: %d",size);
        pWriter.close();
    }
}
