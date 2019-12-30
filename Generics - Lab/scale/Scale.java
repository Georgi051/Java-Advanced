package Generics.scale;

public class Scale<T extends Comparable<T>>{
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier(){
        int result = this.left.compareTo(this.right);
        if (result == 0){
            return null;
        }
        return result > 0 ? this.left : this.right;
    }
}
