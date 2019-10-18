package FilesAndStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String basePath = "C:\\Users\\User\\Desktop\\SoftUni" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\03.CopyBytesOutput.txt";

        FileInputStream input = null;
        FileOutputStream output = null;

        try {
            input = new FileInputStream(inputPath);
            output = new FileOutputStream(outputPath);
            int readByte = input.read();
            while (readByte >= 0){
                if (readByte == ' ' || readByte == '\n'){
                    output.write(readByte);
                }else {
                    String digit = String.valueOf(readByte);
                    for (int i = 0; i < digit.length(); i++) {
                        output.write(digit.charAt(i));
                    }
                }
                readByte = input.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (input != null){
                input.close();
            }
            if (output != null){
                output.close();
            }
        }
    }
}
