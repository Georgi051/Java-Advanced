package FilesAndStreams.exersice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class WordCount {
    public static void main(String[] args) throws IOException {
        String mainPath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputPath = mainPath + "\\words.txt";
        String secondPath = mainPath + "\\text.txt";
        String output = mainPath + "\\output.txt";
        Map<String, Integer> wordsCount = new HashMap<>();

        BufferedReader words = null;
        BufferedReader text = null;
        try {
            words = Files.newBufferedReader(Paths.get(inputPath));
            text = Files.newBufferedReader(Paths.get(secondPath));

            String eachWord = words.readLine();
            while (eachWord != null){
                String[] wordsLine = eachWord.split(" ");
                for (String word : wordsLine) {
                    wordsCount.putIfAbsent(word, 0);
                }
                eachWord = words.readLine();
            }

            String line = text.readLine();
            while (line != null){
                String[] currentLine = line.split("[,.\\- ]+");
                for (String currentWord : currentLine) {
                    if (wordsCount.containsKey(currentWord)){
                        wordsCount.put(currentWord, wordsCount.get(currentWord) + 1);
                    }
                }
                line = text.readLine();
            }

            PrintWriter pWriter = new PrintWriter(new FileWriter(output));
            wordsCount.entrySet().stream().sorted((f,s)->
                    s.getValue().compareTo(f.getValue())
                    ).forEach(word ->{
                pWriter.println(String.format("%s - %d",word.getKey(),word.getValue()));
                    });
            pWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (words != null){
                words.close();
            }
            if (text != null){
                text.close();
            }
        }
    }
}
