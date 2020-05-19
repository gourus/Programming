package sorting.selectionSort;

/**
 * 
 * Selection sort: 
 * This algorithm performs the sorting by selecting proper element and keeping it in appropriate position.
 * 
 * Procedure:
 * 
 * Selection sort basically divides the array into 2 parts. One is sorted and another is remaining array.
 * 
 * First sorted array is empty and this sort continuously fills the data into it by selecting minimum element 
 * from the remining array for each and every iteration.
 * 
 * Advantage:
 * 	Selection sort guarantee the number of swaps as O(n). So, this will give us the best performance when the
 * I/O operations takes more time or when there is a requirement to reduce the access of I/O.
 * 
 * @author sgouru
 *
 */


public class SelectionSort {
	
	public void sort(int [] input){
		
		// Here "i" value represents the end+1 of sorted array. 
		for(int i=0; i< input.length; i++) {
			
			int minimum = i;
			
			// Perform linear search to find the minimum value in remaining array.
			int k = i+1;
			
			while(k < input.length) {
				if(input[minimum] > input[k]) {
					minimum = k;
				}
				k++;
			}
			
			// Swap the value if minimum is changed.
			if(i != minimum) {
				int temp = input[i];
				input[i] = input[minimum];
				input[minimum] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		
		int [] input = new int [] {1,3,4,6,2,7};
		selectionSort.sort(input);
		
		System.out.println("After sorting...");
		for(int i: input) {
			System.out.print(i + " ");
		}
		
	}

}
