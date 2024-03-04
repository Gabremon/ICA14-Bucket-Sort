import java.util.ArrayList;

public class BucketSortOptimized {
    public static void main(String[] args) {
        int[] A = {2, 5, 3, 1, 7, 4}; // Example input array
        int n = A.length;

        ArrayList<Integer>[] B = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            B[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            B[hashFunction(A[i], n)].add(A[i]);
        }

        for (int i = 0; i < n; i++) {
            insertionSort(B[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.addAll(B[i]);
        }

        System.out.println(result);
    }

    // Hash function to determine the index in B for each element of A
    public static int hashFunction(int x, int n) {
        return x * (n - 1) / (x + 1);
    }

    // Insertion sort
    public static void insertionSort(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
    }
}
