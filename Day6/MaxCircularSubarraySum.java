package Day6;

public class MaxCircularSubarraySum {
	
	//Considering All Possible Subarrays – O(n^2) Time and O(1) Space
	static int maxCircularSum(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        // Subarray that starts with index i
        for(int i = 0; i < n; i++) {
            int currSum = 0;
            // Considering all possible endpoints of the 
            // Subarray that begins with index i
            for(int j = 0; j < n; j++) {
                // Circular index
                int idx = (i + j) % n;
                currSum = currSum + arr[idx];            
                res = Math.max(res, currSum);
            }
        }
        return res;
    }
	
	//Using Prefix and Suffix Sum – O(n) Time and O(n) Space
	static int maxCircularSum(int[] arr) {     
        int n = arr.length;
        int suffixSum = arr[n - 1];
        // maxSuffix array to store the value of maximum suffix occurred so far.
        int[] maxSuffix = new int[n + 1];
        maxSuffix[n - 1] = arr[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            suffixSum = suffixSum + arr[i];
            maxSuffix[i] = Math.max(maxSuffix[i + 1], suffixSum);
        }
        // circularSum is Maximum sum of circular subarray
        int circularSum = arr[0];
        // normalSum is Maximum sum subarray considering the array is non-circular
        int normalSum = arr[0];
        int currSum = 0;
        int prefix = 0;

        for(int i = 0; i < n; i++) {
            // Kadane's algorithm
            currSum = Math.max(currSum + arr[i], arr[i]);
            normalSum = Math.max(normalSum, currSum);
          
			// Calculating maximum Circular Sum
            prefix = prefix + arr[i];
            circularSum = Math.max(circularSum, prefix + maxSuffix[i + 1]);
        }
        return Math.max(circularSum, normalSum);
    }

	//Using Kadane's Algorithm – O(n) Time and O(1) Space
	static int maxCircularSum(int[] arr) {
        
        int totalSum = 0;    
        int currMaxSum = 0, currMinSum = 0;
        int maxSum = arr[0], minSum = arr[0];
        
        for(int i = 0; i < arr.length; i++) {
          
            // Kadane's to find maximum sum subarray
            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currMaxSum); 
          
            // Kadane's to find minimum sum subarray
            currMinSum = Math.min(currMinSum + arr[i], arr[i]);
            minSum = Math.min(minSum, currMinSum);
            
            // Sum of all the elements of input array
            totalSum += arr[i];
        }
        
        int normalSum = maxSum;
        int circularSum = totalSum - minSum;
        
        // If the minimum subarray is equal to total Sum
        // then we just need to return normalSum
        if(minSum == totalSum)
            return normalSum;
        
        return Math.max(normalSum, circularSum);
    }
	
    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        System.out.println(maxCircularSum(arr));
    }

}
