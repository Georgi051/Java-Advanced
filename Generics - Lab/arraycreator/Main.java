package Generics.arraycreator;

public class Main {
    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(10,"none");
        Integer[] ints = ArrayCreator.create(Integer.class,10,0);

        int count = 0;
        for (String string : strings) {
            System.out.println(count++ + " " +  string);
        }

        count = 0;
        for (Integer in : ints) {
            System.out.println(count++ + " " + in);
        }
    }
}
