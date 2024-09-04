import java.util.*;

public class BinSort {
    public static void main(String[] args) {
        int[] arr = {42, 32, 33, 52, 37, 47, 51};
        
        System.out.println("Original array:");
        printArray(arr);

        binSort(arr, 10);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Function to implement Bin Sort
    public static void binSort(int[] arr, int numberOfBins) {
        // Find the maximum value in the array
        int max = Arrays.stream(arr).max().getAsInt();
        
        // Create an array of bins (buckets)
        List<Integer>[] bins = new ArrayList[numberOfBins];
        for (int i = 0; i < numberOfBins; i++) {
            bins[i] = new ArrayList<>();
        }

        // Distribute the elements into bins
        for (int num : arr) {
            int binIndex = (num * numberOfBins) / (max + 1);
            bins[binIndex].add(num);
        }

        // Sort each bin and gather the elements back to the array
        int index = 0;
        for (List<Integer> bin : bins) {
            Collections.sort(bin);
            for (int num : bin) {
                arr[index++] = num;
            }
        }
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
