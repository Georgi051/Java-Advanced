package FilesAndStreams;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader bReader = null;
        PrintWriter writer = null;
        int row = 1;
        try {
            bReader = new BufferedReader(new FileReader(inputPath));
            writer = new PrintWriter(new FileWriter(outputPath));
            String line = bReader.readLine();
            while (line != null) {
                if (row++ % 3 == 0) {
                    writer.println(line);
                }
                line = bReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bReader != null) {
                bReader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
