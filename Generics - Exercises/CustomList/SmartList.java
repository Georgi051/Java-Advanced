package CustomList;

import java.util.ArrayList;
import java.util.List;

public class SmartList <T extends Comparable<T>> {
    private List<T> stringList;

    public SmartList() {
        this.stringList = new ArrayList<>();
    }
    public void add(T element){
        this.stringList.add(element);
    }

    public void remove(int index) {
        this.stringList.remove(index);
    }

    public boolean contains(T index) {
        if (this.stringList.contains(index)){
            return true;
        }
        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = this.stringList.get(firstIndex);
        this.stringList.set(firstIndex,this.stringList.get(secondIndex));
        this.stringList.set(secondIndex,temp);
    }

    public void print() {
        for (int i = 0; i < this.stringList.size(); i++) {
            System.out.println(this.stringList.get(i));
        }
    }

    public int greater(T element) {
        int count = 0;
        for (T t : stringList) {
            if (t.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

    public T max() {
        T maxElement = (T) "";
        for (T t : stringList) {
            if (t.compareTo(maxElement) > 0){
                maxElement = t;
            }
        }
        return maxElement ;
    }

    public T min() {
        T minElement = this.stringList.get(1);
        for (T t : stringList) {
            if (t.compareTo(minElement) < 0){
                minElement = t;
            }
        }
        return minElement;
    }
}
