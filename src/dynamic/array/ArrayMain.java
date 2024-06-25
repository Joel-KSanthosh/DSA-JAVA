package dynamic.array;
public class ArrayMain {
    public static void main(String[] args) {
        Array array = new Array<>();
        System.out.println(array.size());
        System.out.println(array);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        System.out.println(array.size());
        System.out.println(array);
        array.remove(2);
        array.removeAt(3);
        System.out.println(array);
        System.out.println(array.size());
        array.set(0, 5);
        System.out.println(array.get(0));
        System.out.println(array);
        array.set(2, 6);
        System.out.println(array);
    }
}
