package Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            String input = scanner.nextLine();

            Box box;
            try{
                int num = Integer.parseInt(input);
                 box = new Box<Integer>(num);
            }catch (Exception e){
                 box = new Box<>(input);
            }
            System.out.println(box.toString());
        }
    }
}
