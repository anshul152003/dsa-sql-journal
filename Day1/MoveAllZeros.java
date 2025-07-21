package Day1;

public class MoveAllZeros {
	
	//using temp array TC = O(n) SC = O(n)
	/*static void pushZerosToEnd(int [] arr) {
		int [] temp = new int[arr.length];
		
		int nz = 0;
		//copy non-zero element to temp[]
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				temp[nz++] = arr[i];
			}
		}
		//fill remaining position in temp with zeros
		while(nz<arr.length) {
			temp[nz++] = 0;
		}
		//copy all the elements from temp[] to arr[]
		for(int i=0; i<arr.length; i++) {
			arr[i] = temp[i];
		}
	}*/
	
	//two traversals
	/*static void pushZerosToEnd(int [] arr) {
		int count = 0;
		
		//if the element is non-zero, replace the element at index 'count' with this element and increment count
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		//now all non-zero elements have been shifted to the front.
		//make all element 0 from count to end
		while(count < arr.length) {
			arr[count++] = 0;
		}
	}*/
	
	//one traversal
	static void pushZerosToEnd(int [] arr) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				
				count++;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {1,2,0,4,3,0,5,0};
		pushZerosToEnd(arr);
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}
}
