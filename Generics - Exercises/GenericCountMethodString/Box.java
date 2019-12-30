package GenericCountMethodString;

public class Box <T extends Comparable<T>>{
    private T element;

    public Box(T element){
        this.element = element;
    }

    public int compareTo(Box<T> o){
        return this.element.compareTo(o.element);
    }
}
