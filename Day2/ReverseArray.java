package Day2;

import java.util.*;

public class ReverseArray {
	
	//Using temp arr TC=O(n) SC=O(n)
	static void reverseArray(int [] arr) {
		int [] temp = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			temp[i] = arr[arr.length - i - 1];
		}
		for(int i=0; i<arr.length; i++) {
			arr[i] = temp[i];
		}
	}
	
	//Using two pointer TC=O(n) SC=O(1)
	static void reverseArray(int [] arr) {
		int left = 0;
		int right = arr.length -1;
		while(left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	
	//itrate only first half of array
	static void reverseArray(int [] arr) {
		int n = arr.length;
		for(int i=0; i< n/2; i++) {
			int temp = arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = temp;
		}
	}
	
	//using recursion
	static void reverseArrayRec(int [] arr, int l, int r) {
		if(l >= r) {
			return;
		}
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
		
		reverseArrayRec(arr, 0, n-1);
	}
	static void reverseArray(int [] arr) {
		int n = arr.length;
		reverseArrayRec(arr, 0, n-1);
	}
	
	//using builtin and collections
	static void reverseArray(int [] arr) {
		Collections.reverse(arr);
	}

	public static void main(String[] args) {
		int [] arr = { 1, 4, 3, 2, 6, 5 };
		reverseArray(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
