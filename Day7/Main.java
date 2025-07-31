import java.util.Arrays;
public class Main {
    //Smallest Missing Positive Number

    //By Sorting - O(n*log n) Time and O(1) Space
    static int missingNumber(int[] arr) {
        Arrays.sort(arr);
        // res will hold the current smallest missing number, initially set to 1
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            // If we have found 'res' in the array, 'res' is no longer missing, so increment it
            if (arr[i] == res) {
                res++;
            } else if (arr[i] > res) {
                break;
            }
        }
        return res;
    }

    //Using Visited Array - O(n) Time and O(n) Space
    static int missingNumber(int[] arr) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            // if element is in range from 1 to n then mark it as visited
            if (arr[i] > 0 && arr[i] <= n)
                vis[arr[i] - 1] = true;
        }
        // Find the first element which is unvisited in the original array
        for (int i = 1; i <= n; i++) {
            if (!vis[i - 1]) {
                return i;
            }
        }
        // if all elements from 1 to n are visited then n+1 will be first positive missing number
        return n + 1;
    }

    //Using Cycle Sort - O(n) Time and O(1) Space
    static int missingNumber(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // if arr[i] is within the range [1, n] and arr[i] is not placed at (arr[i]-1)th index in arr
            while (arr[i] >= 1 && arr[i] <= n
                    && arr[i] != arr[arr[i] - 1]) {
                // then swap arr[i] and arr[arr[i]-1] to place arr[i] to its corresponding index
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }
        // If any number is not at its corresponding index then it is the missing number
        for (int i = 1; i <= n; i++) {
            if (i != arr[i - 1]) {
                return i;
            }
        }
        // If all number from 1 to n are present then n+1 is smallest missing number
        return n + 1;
    }

    //By Negating Array Elements – O(n) Time and O(1) Space
    static int partition(int[] arr) {
        int pivotIdx = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // Move positive elements to the left
            if (arr[i] > 0) {
                int temp = arr[i];
                arr[i] = arr[pivotIdx];
                arr[pivotIdx] = temp;
                pivotIdx++;
            }
        }
        // return index of the first non-positive number
        return pivotIdx;
    }
    static int missingNumber(int[] arr) {
        int k = partition(arr);
        for (int i = 0; i < k; i++) {
            // Find the absolute value to get the original number
            int val = Math.abs(arr[i]);
            // If val is within range, then mark the element at index val-1 to negative
            if (val - 1 < k && arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            }
        }
        // Find first unmarked index
        for (int i = 0; i < k; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        // If all numbers from 1 to k are marked then missing number is k + 1
        return k + 1;
    }

    //By Marking Indices – O(n) Time and O(1) Space
    static int missingNumber(int[] arr) {
        int n = arr.length;
        boolean flag = false;
        // Check if 1 is present in array or not
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                flag = true;
                break;
            }
        }
        // If 1 is not present
        if (!flag)
            return 1;
        // Change out of range values to 1
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n)
                arr[i] = 1;
        }
        // Mark the occurrence of numbers directly within the same array
        for (int i = 0; i < n; i++) {
            arr[(arr[i] - 1) % n] += n;
        }
        // Finding which index has value less than n
        for (int i = 0; i < n; i++) {
            if (arr[i] <= n)
                return i + 1;
        }
        // If array has values from 1 to n
        return n + 1;
    }
    public static void main(String[] args) {
        int[] arr = {2, -3, 4, 1, 1, 7};
        System.out.println(missingNumber(arr));
    }
}