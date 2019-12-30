package OldExamTasks;

import java.util.*;

public class SantasPresentFactory {
    private static final String DOLL = "Doll";
    private static final String WOODEN_TRAIN = "Wooden train";
    private static final String TEDDY_BEAR = "Teddy bear";
    private static final String BICYCLE = "Bicycle";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] materials = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] magic = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> numOfMaterials = fillMaterials(materials);
        ArrayDeque<Integer> magicLevel = fillMagic(magic);

        Map<String,Integer> presents = new TreeMap<>();
        presents.put(DOLL,0);
        presents.put(WOODEN_TRAIN,0);
        presents.put(TEDDY_BEAR,0);
        presents.put(BICYCLE,0);
        boolean dollCraft = false; boolean trainCraft = false;
        boolean bearCraft = false; boolean bicycleCraft = false;


        while (!numOfMaterials.isEmpty() && !magicLevel.isEmpty()){
            int currentMaterial = numOfMaterials.peek();
            int currentMagic = magicLevel.peek();
            int sum = 0;

            if (currentMaterial * currentMagic < 0){
                sum = currentMagic + currentMaterial;
                numOfMaterials.pop();
                magicLevel.poll();
                numOfMaterials.push(sum);
                continue;
            }else if (currentMagic == 0 || currentMaterial == 0){
                if (currentMagic == 0){
                    magicLevel.poll();
                }
                if (currentMaterial == 0){
                    numOfMaterials.pop();
                }
                continue;
            }else {
                sum = currentMagic * currentMaterial;
            }

            switch (sum){
                case 150:
                    presents.put(DOLL, presents.get(DOLL) + 1);
                    dollCraft = true;
                    magicLevel.poll();
                    numOfMaterials.pop();
                    break;
                case 250:
                    presents.put(WOODEN_TRAIN, presents.get(WOODEN_TRAIN) + 1);
                    trainCraft = true;
                    magicLevel.poll();
                    numOfMaterials.pop();
                    break;
                case 300:
                    presents.put(TEDDY_BEAR, presents.get(TEDDY_BEAR) + 1);
                    bearCraft = true;
                    magicLevel.poll();
                    numOfMaterials.pop();
                    break;
                case 400:
                    presents.put(BICYCLE, presents.get(BICYCLE) + 1);
                    bicycleCraft = true;
                    magicLevel.poll();
                    numOfMaterials.pop();
                    break;
                default:
                   magicLevel.poll();
                   int curr =  numOfMaterials.pop();
                   numOfMaterials.push(curr + 15);
            }
        }
        if ((bearCraft && bicycleCraft) || (dollCraft && trainCraft)){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }

        if (!numOfMaterials.isEmpty()){
            System.out.print("Materials left: ");
            System.out.println(numOfMaterials.toString().replaceAll("[\\[\\]]", ""));
        }

        if (!magicLevel.isEmpty()){
            System.out.print("Magic left: ");
            System.out.println(magicLevel.toString().replaceAll("[\\[\\]]", ""));
        }

        presents.entrySet().stream().filter(p -> p.getValue() != 0)
                .forEach(entry -> System.out.printf("%s: %d%n",entry.getKey(),entry.getValue()));

    }

    private static ArrayDeque<Integer> fillMagic(int[] magic) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int m : magic) {
            deque.offer(m);
        }
        return deque;
    }

    private static ArrayDeque<Integer> fillMaterials(int[] materials) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int material : materials) {
            deque.push(material);
        }
        return deque;
    }
}
