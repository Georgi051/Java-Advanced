package FilesAndStreams;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try(FileInputStream inputStream = new FileInputStream(path)) {
            int oneByte = inputStream.read();
            while (oneByte >= 0){
                System.out.print(Integer.toBinaryString(oneByte)+ " ");
               oneByte = inputStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }
}
