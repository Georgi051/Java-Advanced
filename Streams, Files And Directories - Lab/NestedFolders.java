package FilesAndStreams;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class NestedFolders {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

        File file = new File(basePath);
        File[] files = file.listFiles();

        int counterFolder = 0;
        ArrayDeque<File> toTraverse = new ArrayDeque<>(Arrays.asList(files));
        while (toTraverse.size() > 0) {
            File currentFile = toTraverse.poll();
            if (currentFile.isDirectory()) {
                System.out.println(currentFile.getName());
                List<File> fileList = Arrays.asList(currentFile.listFiles());
                toTraverse.addAll(fileList);
                counterFolder++;
            }
        }
        System.out.println(counterFolder + " folders");
    }
}
