package Day2;

public class RotateArrayByD {
	
	//rotate one by one tc=O(d * n) sc=O(1)
	static void rotateArr(int [] arr, int d) {
		//repeat the ratation d times
		for(int i=0; i<d; i++) {
			int first = arr[0];
			for(int j=0; j<arr.length-1; j++) {
				arr[j] = arr[j+1];
			}
			arr[arr.length-1] = first;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 5;

        rotateArr(arr, d);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
	}

}
