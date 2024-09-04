import java.util.Arrays;

public class CountingSort {

    // CountingSort function
    public static void countingSort(int[] array, int maxVal) {
        int n = array.length;
        int[] count = new int[maxVal + 1];
        int[] output = new int[n];

        // Store count of each element
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
        }

        // Store cumulative count
        for (int i = 1; i <= maxVal; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the output array to array, so that array now contains sorted elements
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // Driver method to test the CountingSort
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        int maxVal = 8;
        countingSort(array, maxVal);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
