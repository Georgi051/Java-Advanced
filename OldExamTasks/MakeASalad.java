package OldExamTasks;

import java.util.*;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vegetables = scanner.nextLine().split("\\s+");
        int[] calories  = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<String> vegetableQueue= new ArrayDeque<>();
        ArrayDeque<Integer> caloriesStack  = new ArrayDeque<>();

        for (String vegetable : vegetables) {
            if (vegetable.equals("tomato") || vegetable.equals("carrot")
                    || vegetable.equals("lettuce")|| vegetable.equals("potato")){
                vegetableQueue.offer(vegetable);
            }
        }

        for (int calorie : calories) {
            caloriesStack.push(calorie);
        }

        while (!vegetableQueue.isEmpty() && !caloriesStack.isEmpty()){
            int caloriesSalad = caloriesStack.peek();

           while (caloriesSalad > 0 && !vegetableQueue.isEmpty()){
               String currentVegetable = vegetableQueue.pop();
               int caloriesForCurrentVegetable = 0;
               switch (currentVegetable){
                   case "tomato":
                       caloriesForCurrentVegetable = 80;
                       break;
                   case "carrot":
                       caloriesForCurrentVegetable = 136;
                       break;
                   case "lettuce":
                       caloriesForCurrentVegetable = 109;
                       break;
                   case "potato":
                       caloriesForCurrentVegetable = 215;
                       break;
               }
              caloriesSalad -= caloriesForCurrentVegetable;
           }
            System.out.print(caloriesStack.pop() + " ");
        }
        System.out.println();
        if (!caloriesStack.isEmpty()){
            for (int lastCalorie : caloriesStack) {
                System.out.print(lastCalorie + " ");
            }
        }

        if (!vegetableQueue.isEmpty()){
            for (String vegetable : vegetableQueue) {
                System.out.print(vegetable + " ");
            }
        }
    }
}
