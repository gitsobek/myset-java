import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class NumberSet {
    public static int MAX_SIZE = 100;
    private int[] nSet = new int[MAX_SIZE];
    private int size;

    public void add(int i) {
        if(size == nSet.length) throw new ArrayIndexOutOfBoundsException("Array is too big.");
        nSet[size++] = i;
    }

    public void remove(int i) {
        if(contains(i) == false) throw new IllegalArgumentException("No such element.");
        nSet = Arrays.stream(nSet)
                .filter(a -> a != i)
                .toArray();
    }

    public int getRandomValue() {
        if(nSet.length == 0) throw new IllegalStateException("Array is empty.");
        int pickedValue = nSet[new Random().nextInt(size)];
        remove(pickedValue);
        return pickedValue;
    }

    public int getSumOfElements() {
        if(nSet.length == 0) throw new IllegalStateException("Array is empty.");
        return Arrays.stream(nSet).sum();
    }

    public void divideAllElementsBy(int d) {
        if(d == 0) throw new ArithmeticException("Cannot divide by zero.");
        nSet = Arrays.stream(nSet)
                .map(a -> a / d)
                .toArray();
    }

    public boolean contains(int i) {
        return IntStream.of(nSet)
                .anyMatch(x -> x == i);
    }

    public int getSize() {
        return nSet.length;
    }

    public static void main(String[] args) {
        NumberSet mySet = new NumberSet();

        System.out.println("Let's add some elements.");
        mySet.add(6);
        mySet.add(-4);
        mySet.add(2);
        mySet.add(10);
        mySet.add(8);
        mySet.add(4);
        mySet.add(5);
        mySet.add(2);
        System.out.println(Arrays.toString(mySet.nSet));

        System.out.println("Now, remove value 2!");
        mySet.remove(2);
        System.out.println(Arrays.toString(mySet.nSet));

        if(mySet.contains(11))
            System.out.println("11 is in the set.");
        else
            System.out.println("11 is not in the set.");

        System.out.println("Let's divide the elements by 2, shall we?");
        mySet.divideAllElementsBy(2);
        System.out.println(Arrays.toString(mySet.nSet));

        System.out.println("Nice, what is the sum of this set?");
        System.out.println("Sum of elements: " + mySet.getSumOfElements());

        System.out.println("Look, a random value!");
        System.out.println("Random value: " + mySet.getRandomValue());

        System.out.println("Will the application remove the random number. I bet yes!");
        System.out.println(Arrays.toString(mySet.nSet));

        System.out.println("Last thing, what is the size of this set?");
        System.out.println("Size of set: " + mySet.getSize());
    }
}
