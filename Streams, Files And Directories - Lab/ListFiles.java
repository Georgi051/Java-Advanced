package FilesAndStreams;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\Files-and-Streams";

        File file = new File(inputPath);
        File[] files = file.listFiles();

        for (File currentFile : files) {
            if (!currentFile.isDirectory()){
                System.out.printf("%s: [%d]\n",currentFile.getName(),currentFile.length());
            }
        }
    }
}
