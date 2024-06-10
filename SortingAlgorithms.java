import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] sizes = { 10000, 12000, 15000, 17500, 20000 };
        Random random = new Random();

        for (int size : sizes) {
            int[] arr = random.ints(size, 0, 100000).toArray();

            long startTime, endTime, duration;

            // Bubble Sort
            int[] bubbleArr = arr.clone();
            startTime = System.nanoTime();
            bubbleSort(bubbleArr);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Bubble Sort, size " + size + ": " + duration + " ns");

            // Selection Sort
            int[] selectionArr = arr.clone();
            startTime = System.nanoTime();
            selectionSort(selectionArr);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Selection Sort, size " + size + ": " + duration + " ns");

            // Insertion Sort
            int[] insertionArr = arr.clone();
            startTime = System.nanoTime();
            insertionSort(insertionArr);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Insertion Sort, size " + size + ": " + duration + " ns");

            // Merge Sort
            int[] mergeArr = arr.clone();
            startTime = System.nanoTime();
            mergeSort(mergeArr);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Merge Sort, size " + size + ": " + duration + " ns");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

}
