package FilesAndStreams.exersice;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String mainPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";

        String inputPath = mainPath + "\\input.txt";
        String outputPath = mainPath + "\\output2.txt";
        BufferedReader bReader = null;
        PrintWriter pWriter = null;

        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        List<String> punctuations = Arrays.asList("!", ",", ".", "?");
        int[] counts = new int[3];
        try {
            bReader = Files.newBufferedReader(Paths.get(inputPath));
            pWriter = new PrintWriter(new FileWriter(outputPath));
            String oneByte = bReader.readLine();
            while (oneByte != null){
                for (int i = 0; i < oneByte.length(); i++) {
                    char symbol = oneByte.charAt(i);
                    if (!Character.isWhitespace(symbol)){
                        if (vowels.contains(symbol + "")){
                            counts[0]++;
                        }else if (punctuations.contains(symbol + "")){
                            counts[2]++;
                        }else {
                            counts[1]++;
                        }
                    }
                }
                oneByte = bReader.readLine();
                System.out.println();
            }
            pWriter.println(String.format("Vowels: %d",counts[0]));
            pWriter.println(String.format("Consonants: %d",counts[1]));
            pWriter.println(String.format("Punctuation: %d",counts[2]));
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
