package Day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
	
	//Generate all permutations tc=O(n! * n) sc=O(n! *n)
	static void generatePermutations(List<List<Integer>> res, int[] arr, int idx) {
		//Base case: if idx reaches the end of array
		if(idx == arr.length - 1) {
			List<Integer>  temp = new ArrayList<>();
            for (int x : arr) temp.add(x);
            res.add(temp);
            return;
		}
		 // Generate all permutations by swapping
        for (int i = idx; i < arr.length; i++) {
            swap1(arr, idx, i);
            // Recur for the next index
            generatePermutations(res, arr, idx + 1);
            // Backtrack to restore original array
            swap1(arr, idx, i);
        }
	}
	static void swap1(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
	// Function to find the next permutation
    static void nextPermutation1(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        // Generate all permutations
        generatePermutations(res, arr, 0);
        // Sort all permutations lexicographically
        Collections.sort(res, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });
        // Find the current permutation index
        for (int i = 0; i < res.size(); i++) {
            // If current permutation matches input
            boolean match = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != res.get(i).get(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                // If it's not the last permutation
                if (i < res.size() - 1) {
                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = res.get(i + 1).get(j);
                    }
                }
                // If it's the last permutation
                else {
                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = res.get(0).get(j);
                    }
                }
                break;
            }
        }
    }

    //Generating Only Next - O(n) Time and O(1) Space
    static void nextPermutation2(int[] arr) {
        int n = arr.length;
        // Find the pivot index
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }
        // If pivot point does not exist, 
        // reverse the whole array
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return ;
        }
        // Find the element from the right 
        // that is greater than pivot
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                swap2(arr, i, pivot);
                break;
            }
        }
        // Reverse the elements from pivot + 1 to the end
        reverse(arr, pivot + 1, n - 1);
    }
    // Helper method to reverse array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap2(arr, start++, end--);
        }
    }
    // Helper method to swap two elements
    private static void swap2(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
   
    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 7, 5, 0};

        nextPermutation1(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
        
        System.out.println();
        nextPermutation2(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
