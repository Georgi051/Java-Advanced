package SetsAndMaps.exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UsesLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> logBook = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] data = input.split("[= ]");
            String ip = data[1];
            String userName = data[5];

            if (!logBook.containsKey(userName)) {
                logBook.put(userName, new LinkedHashMap<>());
            }
            if (!logBook.get(userName).containsKey(ip)) {
                logBook.get(userName).put(ip, 1);
            } else {
                logBook.get(userName).put(ip, logBook.get(userName).get(ip) + 1);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> logEntry : logBook.entrySet()) {
            System.out.println(logEntry.getKey() + ":");
            LinkedHashMap<String, Integer> ipAndCountEmails = logEntry.getValue();

            int count = ipAndCountEmails.size();
            for (Map.Entry<String, Integer> entry : ipAndCountEmails.entrySet()) {
                if (count-- > 1) {
                    System.out.printf("%s => %d, ", entry.getKey(), entry.getValue());
                } else {
                    System.out.printf("%s => %d.\n", entry.getKey(), entry.getValue());
                }
            }

            //String[] typeSymbol = getSymbol(ipAndCountEmails);
            //System.out.printf("%s.%n",String.join(", ",typeSymbol));
        }
    }

   // private static String[] getSymbol(LinkedHashMap<String, Integer> ipBook) {
   //     String[] result = new String[ipBook.size()];
   //     int i = 0;
   //     for (Map.Entry<String, Integer> entry : ipBook.entrySet()) {
   //         result[i] = String.format("%s => %d", entry.getKey(), entry.getValue());
   //         i++;
   //     }
   //     return result;
   // }
}
