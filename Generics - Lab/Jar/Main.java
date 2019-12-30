package Generics.Jar;

public class Main {
    public static void main(String[] args) {

        Jar<String> storage = new Jar();

        storage.add("first");
        storage.add("second");

        System.out.println(storage.remove());
    }
}
