package Generics.ListUtils;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> items){
        if (items.size() == 0){
            throw new IllegalArgumentException("Max on empty list");
        }
        T currentMax = items.get(0);

        for (int i = 1; i < items.size(); i++) {
            T current = items.get(i);
            if (currentMax.compareTo(current) < 0){
                currentMax = current;
            }
        }
        return currentMax;
    }

    public static <T extends Comparable<T>> T getMin(List<T> items){
        if (items.size() == 0){
            throw new IllegalArgumentException("Min on empty list");
        }
        T currentMax = items.get(0);

        for (int i = 1; i < items.size(); i++) {
            T current = items.get(i);
            if (currentMax.compareTo(current) > 0){
                currentMax = current;
            }
        }
        return currentMax;
    }
}
