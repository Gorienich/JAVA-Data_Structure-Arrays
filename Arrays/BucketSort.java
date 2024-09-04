import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    // BucketSort function
    public static void bucketSort(float[] array, int n) {
        if (n <= 0)
            return;

        // Create empty buckets
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++)
            buckets[i] = new ArrayList<>();

        // Add elements to the buckets
        for (float num : array) {
            int bucketIndex = (int) (num * n);
            buckets[bucketIndex].add(num);
        }

        // Sort individual buckets
        for (ArrayList<Float> bucket : buckets)
            Collections.sort(bucket);

        // Concatenate all buckets into array
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                array[index++] = num;
            }
        }
    }

    // Driver method to test the BucketSort
    public static void main(String[] args) {
        float[] array = {0.897f, 0.565f, 0.656f, 0.123f, 0.665f, 0.343f};
        int n = array.length;
        bucketSort(array, n);
        System.out.println("Sorted array: ");
        for (float num : array)
            System.out.print(num + " ");
    }
}
