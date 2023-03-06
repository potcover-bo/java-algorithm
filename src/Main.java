import basic.ArrayGenerator;
import basic.LineSearch;

public class Main {
    public static void main(String[] args) {
        /*Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int res = basic.LineSearch.search(data, 16);
        System.out.println(res);

        int res2 = basic.LineSearch.search(data, 666);
        System.out.println(res2);

        basic.Student[] students = {new basic.Student("Alice"), new basic.Student("Charles")};

        basic.Student alice = new basic.Student("Alice");
        System.out.println(basic.LineSearch.search(students, alice));*/

        int[] dataSize = {100000, 1000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateOrderedArray(n);
            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LineSearch.search(arr, n);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000.0;
            System.out.println("n = " + n + ", cost: " +time + "ms");
        }

    }

}
