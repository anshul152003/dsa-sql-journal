package Day1;

import java.util.*;

public class SecondLargest {
	
	//Brute Force approach TC=O(n logn) SC=O(1)
	/*public static int getSecondLargest(int[] arr) {
		if(arr.length < 2) return -1;
		// Sort the array in non-decreasing order
		Arrays.sort(arr); 
		
		int largest = arr[arr.length-1];
		
		// start from second last element as last element is the largest
		for(int i=arr.length-2; i>=0; i--) {
		
		 // return the first element which is not equal to the largest element
			if(arr[i] < largest) return arr[i];
		}
		return -1;
	}*/
	
	//Using set + sorting  TC=O(n logn) SC=O(n)
	/*public static int getSecondLargest(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for(int num : arr) {
			set.add(num);
		}
		if(set.size() < 2) return -1;
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		return list.get(list.size() - 2);
	}*/
	
	// using one traversal but cannot handle negative value 
	/*public static int getSecondLargest(int[] arr) {
    	int largest = -1, secondLargest = -1;

    	// finding the second largest element
    	for (int i = 0; i < arr.length; i++) {

        // If arr[i] > largest, update second largest with
        // largest and largest with arr[i]
        if(arr[i] > largest) {
            secondLargest = largest;
            largest = arr[i];
        }
        // If arr[i] < largest and arr[i] > second largest, 
        // update second largest with arr[i]
        else if(arr[i] < largest && arr[i] > secondLargest) {
            secondLargest = arr[i];
        }
    }
    return secondLargest;
    }*/
	
	//Approach with only one traversal and can handle negative value TC=O(n) SC=O(1)
	public static int getSecondLargest(int[] arr) {
        if(arr.length < 2) return -1;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for(int num : arr){
            if(num > first){
                second = first;
                first = num;
            }
            else if(num > second && num != first){
                second = num;
            }
        }
        if (second == Integer.MIN_VALUE){
            return -1;
        }
        else return second;
    }

	public static void main(String[] args) {
		
		int[] numbers = {5, 3, 9, 2, 10, 4};
		System.out.println(getSecondLargest(numbers));
	}

}
