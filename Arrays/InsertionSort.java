import java.util.Arrays;

public class InsertionSort {

    // InsertionSort function
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Driver method to test the InsertionSort
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};
        insertionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
