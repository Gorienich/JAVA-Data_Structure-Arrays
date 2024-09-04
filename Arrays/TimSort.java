import java.util.Arrays;

public class TimSort {

    private static final int RUN = 32;

    // TimSort function
    public static void timSort(int[] array, int n) {
        for (int i = 0; i < n; i += RUN)
            insertionSort(array, i, Math.min((i + 31), (n - 1)));

        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                merge(array, left, mid, right);
            }
        }
    }

    // InsertionSort function used by TimSort
    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= left && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    // Merge function used by TimSort
    private static void merge(int[] array, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];

        for (int x = 0; x < len1; x++) {
            leftArray[x] = array[left + x];
        }
        for (int x = 0; x < len2; x++) {
            rightArray[x] = array[mid + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < len2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Driver method to test the TimSort
    public static void main(String[] args) {
        int[] array = {5, 21, 7, 23, 19};
        int n = array.length;
        timSort(array, n);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
