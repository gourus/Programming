package sorting.mergeSort;

import java.util.Arrays;

/**
 * 
 * This answer is taken from Geeks For Geeks.
 * 
 * Source:
 * https://www.geeksforgeeks.org/merge-sort-with-o1-extra-space-merge-and-on-lg-n-time/?ref=rp
 * 
 * As we all know, we need extra space to Merge elements of array in Merge sort. We will use some mathematical 
 * tricks to get rid of the extra space.
 * 
 * NOTE: As of now, This algo will work with Integer elements only.
 * 
 * For integer types, merge sort can be made inplace using some mathematics trick of modulus and division. 
 * That means storing two elements value at one index and can be extracted using modulus and division. 
 * First we have to find a value greater than all the elements of the array. Now we can store the original 
 * value as modulus and the second value as division. Suppose we want to store arr[i] and arr[j] both at index i(means in arr[i]). 
 * First we have to find a ‘maxval’ greater than both arr[i] and arr[j]. Now we can store as arr[i] = arr[i] + arr[j]*maxval. 
 * Now arr[i]%maxval will give the original value of arr[i] and arr[i]/maxval will give the value of arr[j]. 
 * So below is the implementation on merge sort.
 * 
 * For example, we have array with [5, 4]
 * 
 * As merge sort rules, Above array will be divided and merged
 * 
 * like, [5]  and [4] arrays merged as [4, 5] by using extra space.
 * 
 * But this algo works as.
 * 
 * 1.	Find element which is greater then all the elements in given array. Here 5 is max element in array.
 * 		So, 6 is larger compared to all elements in array.
 * 
 * 2.	As per merge sort divide array into half. Resultant arrays are [5] [4].
 * 		Perform merge operation by following this.
 * 
 *  	here arr[i] = 5, arr[j] = 4, maxElement = 6
 *  	k = i;
 *  	if( arr[i] >= arr[j]) {
 *  		arr[k] = arr[k] + (arr[j] % maxElement) * maxElement. 
 *  		k++; j++;
 *  	} else {
 *  		arr[k] = arr[k] + (arr[i] % maxElement) * maxElement.
 *  		k++; i++;
 *  	}
 *  
 *  	// If we execute the above operation..
 *  
 *  	5 is greater than 4. and arr[k] is 5
 *  	arr[k] = arr[k] + (arr[j] % maxElement) * maxElement.
 *  	arr[k] = 5 + ( 4 % 6 ) * 6;
 *  	arr[k] = 5 + (4 * 6) = 29.
 *  	
 *  	After this operation, the array values will be [29, 4]
 *  	
 *  	First while loop breaks here, as j is greater then "end" element.
 *  	
 *  	i = 0; j = 1; k = 1; arr = [29, 4]
 *  	while( i <= mid ) {
 *  		arr[k] = arr[k] + (arr[i] % maxElement) * maxEleent;
 *  	}
 *  
 *  	arr[k] = arr[1] + (arr[0] % 6) * 6;
 *  	arr[k] = 4 + ( 29 % 6 ) * 6  = 4 + (5 * 6) = 34
 *  
 *   	After this operation, array will become arr = [29, 34]
 *   
 *   	Now extract the original elements.
 *   	
 *   	for ( int i=0; i<=end; i++ ) {
 *   		arr[i] = arr[i] / maxElement;
 *   	}
 *   
 *   	arr[0] = arr[0] / 6 = 29 / 6 = 4;
 *   	arr[1] = arr[1] / 6 = 34 / 6 = 5;
 *   
 *   	After this operation, array will be : arr = [4, 5];
 *   
 *   	I hope you understood this. I think, we can also make this for characters by converting them to ascii values.
 * 
 * @author sgouru
 *
 */

public class MergeSort_with_no_extra_space {

	
	
	public void sort(int[] input) {
		// Getting the element which is hreater than all elements in the array.
		int maxElement = Arrays.stream(input).max().getAsInt() + 1;
		mergeSortHelper(input, 0, input.length-1, maxElement);
	}

	private void mergeSortHelper(int[] input, int start, int end, int maxElement) {
		
		// Base condition
		if( start >= end ) {
			return;
		}
		
		int mid = (start + end)/2;
		
		// Divide array from start to middle
		mergeSortHelper(input, start, mid, maxElement);
		
		// Divide array from middle+1 to end
		mergeSortHelper(input, mid+1, end, maxElement);
		
		// Merge the above arrays
		merge(input, start, mid, end, maxElement);
	}

	private void merge(int[] input, int start, int mid, int end, int maxElement) {
		
		// Copy the start, mid and end values
		int i = start; 	// Represents the start of array1.
		int j = mid+1; 	// Represents the start of array2.
		int k = start;		// Represents the start of array which is going to be sorted.
		
		// Performing merge operation.
		while(i <= mid && j<= end) {
			
			if( input[i]%maxElement > input[j]%maxElement) {
				input[k] = input[k] + (input[j] % maxElement) * maxElement;
				k++; j++;
			} else {
				input[k] = input[k] + (input[i] % maxElement) * maxElement;
				k++; i++;
			}
		}
		
		// We are here.. means, any of the array from array1 and array2 are completed merging.
		// So, we are going to check for remaining elements is array and adding them to input. 
		
		// If the elements in first array still exists 
		// Then all the remaining elements in first array is greater than the previous included elements.
		// Because array 2 elements are completed and both arrays are sorted.
		// So, go ahed and add the array 1 elements directly.
		while(i <= mid) {
			input[k] = input[k] + (input[i] % maxElement) * maxElement;
			k++; i++;			
		}
		
		// Or if array 1 elements are ended and we are left with only array 2 elements.
		// That means, all remaining elements in array 2 are greater. So add to the list.
		while(j <= end) {
			input[k] = input[k] + (input[j] % maxElement) * maxElement;
			k++; j++;
		}
		
		// Now revert back the changes we did previously.
		for(int index=start; index<=end; index++) {
			input[index] = input[index] / maxElement;
		}
		
	}
	
	public static void main(String[] args) {
		
		MergeSort_with_no_extra_space mergeSort = new MergeSort_with_no_extra_space();
		
		int[] input = {999, 612, 589, 856, 56, 945, 243};
		//int[] input = {5, 4, 3, 2, 1};
		
		mergeSort.sort(input);
	    System.out.println("Sorted array "); 
	    
	    for (int i = 0; i < input.length; i++)  
	    { 
	        System.out.print(input[i] + " "); 
	    } 
	}
	
}
