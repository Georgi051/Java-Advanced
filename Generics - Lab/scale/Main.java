package Generics.scale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> intScale = new Scale<>(5,7);
        Scale<String> stringScale = new Scale<>("left","right");

        System.out.println(intScale.getHeavier());
        System.out.println(stringScale.getHeavier());
    }
}
