package Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementII {
	
	//Using Nested Loops - O(n^2) Time and O(1) Space
	
    static List<Integer> findMajority1(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            
            // Count the frequency of arr[i]
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == arr[i])
                    cnt += 1;
            }
          
            // Check if arr[i] is a majority element
            if (cnt > (n / 3)) {
              
                // Add arr[i] only if it is not already
                // present in the result
                if (res.size() == 0 || arr[i] != res.get(0)) {
                    res.add(arr[i]);
                }
            }
          
            // If we have found two majority elements, 
            // we can stop our search
            if (res.size() == 2) {
                if (res.get(0) > res.get(1))
                    java.util.Collections.swap(res, 0, 1);
                break;
            }
        }

        return res;
    }
    
    //Using Hash Map or Dictionary - O(n) Time and O(n) Space
    static List<Integer> findMajority2(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        // find frequency of each number
        for (int ele : arr)
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
      
        // Iterate over each key-value pair in the hash map
        for (Map.Entry<Integer, Integer> it : freq.entrySet()) {
            int ele = it.getKey();
            int cnt = it.getValue();
          
            // Add the element to the result, if its frequency
        	// if greater than floor(n/3)
            if (cnt > n / 3)
                res.add(ele);
        }
      
        if (res.size() == 2 && res.get(0) > res.get(1)) {
            int temp = res.get(0);
            res.set(0, res.get(1));
            res.set(1, temp);
        }
        return res;
    }
    
    //Boyer-Moore’s Voting Algorithm - O(n) Time and O(1) Space
    static List<Integer> findMajority3(int[] arr) {
        int n = arr.length;

        // Initialize two candidates and their counts
        int ele1 = -1, ele2 = -1;
        int cnt1 = 0, cnt2 = 0;

        for (int ele : arr) {
          
            // Increment count for candidate 1
            if (ele1 == ele) {
                cnt1++;
            }
          
            // Increment count for candidate 2
            else if (ele2 == ele) {
                cnt2++;
            }
          
            // New candidate 1 if count is zero
            else if (cnt1 == 0) {
                ele1 = ele;
                cnt1++;
            }
          
            // New candidate 2 if count is zero
            else if (cnt2 == 0) {
                ele2 = ele;
                cnt2++;
            }
          
            // Decrease counts if neither candidate
            else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;

        // Count the occurrences of candidates
        for (int ele : arr) {
            if (ele1 == ele) cnt1++;
            if (ele2 == ele) cnt2++;
        }

        // Add to result if they are majority elements
        if (cnt1 > n / 3) res.add(ele1);
        if (cnt2 > n / 3 && ele1 != ele2) res.add(ele2);
        
        if (res.size() == 2 && res.get(0) > res.get(1)) {
            int temp = res.get(0);
            res.set(0, res.get(1));
            res.set(1, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 1, 3, 2, 1, 1};
        
        List<Integer> res1 = findMajority1(arr);
        System.out.print("Brute Force: ");
        for (int ele : res1) System.out.print(ele + " ");
        System.out.println();
        
        List<Integer> res2 = findMajority2(arr);
        System.out.print("HashMap: ");
        for (int ele : res2) System.out.print(ele + " ");
        System.out.println();
        
        List<Integer> res3 = findMajority3(arr);
        System.out.print("Boyer-Moore: ");
        for (int ele : res3) System.out.print(ele + " ");
        System.out.println();
    }

}
