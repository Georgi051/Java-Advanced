package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartList<String> smartList = new SmartList<String>();

        commandInterpreter(scanner, smartList);
    }

    private static void commandInterpreter(Scanner scanner, SmartList<String> smartList) {
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] data = input.split(" ");
            switch (data[0]){
                case "Add":
                    smartList.add(data[1]);
                    break;
                case "Remove":
                    smartList.remove(Integer.parseInt(data[1]));
                    break;
                case "Contains":
                    System.out.println(smartList.contains(data[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(data[1]);
                    int secondIndex = Integer.parseInt(data[2]);
                    smartList.swap(firstIndex,secondIndex);
                    break;
                case "Greater":
                    System.out.println(smartList.greater(data[1]));
                    break;
                case "Max":
                    System.out.println(smartList.max());
                    break;
                case "Min":
                    System.out.println(smartList.min());
                    break;
                case "Print":
                    smartList.print();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
