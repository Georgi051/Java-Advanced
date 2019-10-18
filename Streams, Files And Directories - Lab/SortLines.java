package FilesAndStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String basePath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\06.SortLinesOutput.txt";

        Path inputRowPath = Paths.get(inputPath);
        Path outputRowPath = Paths.get(outputPath);

        List<String> allLines = Files.readAllLines(inputRowPath);
        Collections.sort(allLines);

        Files.write(outputRowPath, allLines);
    }
}
