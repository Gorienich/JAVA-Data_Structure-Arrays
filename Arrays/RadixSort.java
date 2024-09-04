import java.util.Arrays;

public class RadixSort {

    // RadixSort function
    public static void radixSort(int[] array) {
        int max = getMax(array);

        // Apply counting sort to sort elements based on place value.
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(array, exp);
    }

    // A utility function to get maximum value in array
    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    // A function to do counting sort of array[] according to the digit represented by exp.
    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++)
            count[(array[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains actual
        // position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to array[], so that array[] now contains sorted numbers
        System.arraycopy(output, 0, array, 0, n);
    }

    // Driver method to test the RadixSort
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
