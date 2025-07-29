package Day6;

public class MaxProductSubarray {
	
	//Using Two Nested Loops – O(n^2) Time and O(1) Space
	static int maxProduct(int arr[]) { 
      	int n = arr.length;
        int maxProd = arr[0];
        for (int i = 0; i < n; i++) {
            int mul = 1;
            // traversing in current subarray
            for (int j = i; j < n; j++) {
                mul *= arr[j];
                // updating result every time to keep track of the maximum product
                maxProd = Math.max(maxProd, mul);
            }
        }
        return maxProd;
    }
	
	//Greedy Min-Max Product - O(n) Time and O(1) Space
	static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    static int maxProduct(int[] arr) {
        int n = arr.length;
        // max product ending at the current index
        int currMax = arr[0];
        // min product ending at the current index
        int currMin = arr[0];
        // Initialize overall max product
        int maxProd = arr[0];
        // Iterate through the array
        for (int i = 1; i < n; i++) {        
            // Temporary variable to store the maximum product ending at the current index
            int temp = max(arr[i], arr[i] * currMax, arr[i] * currMin);
            // Update the minimum product ending at the current index
            currMin = min(arr[i], arr[i] * currMax, arr[i] * currMin);
            // Update the maximum product ending at the current index
            currMax = temp;
            // Update the overall maximum product
            maxProd = Math.max(maxProd, currMax);
        }
        return maxProd;
    }
    
    //By Traversing in Both Directions - O(n) Time and O(1) Space
    static int maxProduct(int[] arr) {
        int n = arr.length;
        int maxProd = Integer.MIN_VALUE;
        // leftToRight to store product from left to Right
        int leftToRight = 1; 
        // rightToLeft to store product from right to left
        int rightToLeft = 1;
        for (int i = 0; i < n; i++) {
            if (leftToRight == 0)
                leftToRight = 1;
            if (rightToLeft == 0)
                rightToLeft = 1;
      
            // calculate product from index left to right
            leftToRight *= arr[i]; 
            // calculate product from index right to left
            int j = n - i - 1;
            rightToLeft *= arr[j];
            maxProd = Math.max(leftToRight, 
                           	Math.max(rightToLeft, maxProd));
        }
        return maxProd;
    }
	
    public static void main(String[] args) {
        int arr[] = { -2, 6, -3, -10, 0, 2 };
        System.out.println(maxProduct(arr));
    }

}
