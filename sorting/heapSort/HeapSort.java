package sorting.heapSort;


public class HeapSort {
	
	private void heapify(int [] input, int inputLength, int root) {
		
		int largest = root;

		int rightChild = 2 * root + 1;
		int leftChild = 2 * root + 2;
		
		// Check if the right child is greater than the root. If yes, assign it to largest.
		if(rightChild < inputLength && input[largest] < input[rightChild]) {
			largest = rightChild;
		}
		
		// Check if the left child is greater than the present largest. If yes, assign it to largest.
		if(leftChild < inputLength && input[largest] < input[leftChild]) {
			largest = leftChild;
		}
		
		// If the root is not the largest, then swap ut with largest.
		if(largest != root) {
			
			int temp = input[largest];
			input[largest] = input[root];
			input[root] = temp;
			
			heapify(input, inputLength, largest);
			
		}
				
	}
	
	public void heapSort(int [] input) {
		
		int inputLength = input.length;
		
		// Input is an unsorted array. Before going to perform heap sort operation,
		// we need to build a heap from input array. 
		
		// We will not tuch the leaf elements. Because, leaf elements are 
		// it-self max or min heap.
		// So, start building heap from non leaf element.
		
		// As we know, the heap is an almost complete binary tree.
		// the leaf nodes starts from floor(inputLength/2) +1 to inputLength
		
		for(int nonLeafNodeIndex = inputLength/2-1; nonLeafNodeIndex >= 0; nonLeafNodeIndex-- ) {
			heapify(input, inputLength, nonLeafNodeIndex);
		}
		
		
		// We are here now. That means, heap is ready. 
		// If it is a maxHeap, then the root element or 0th element of heap is maximum value
		// If it is minHeap, then the root element or 0th element of heap is minimum value
		
		// So, we found the max or minimum element. So array is sorted with one element.
		// To sort the total array, we need remove the first element, store it and perform heapify.
		
		for(int element = inputLength-1; element > 0; element--) {

			// Store the root at the last of the array by swapping.
			int temp = input[0];
			input[0] = input[element];
			input[element] = temp;
			
			// Element at index 0 is changes. So perform the heapify for element at index 0.
			// If the changed element breaks the heap property, then construct it.
			
			heapify(input, element, 0);
		}
	}
	
	public static void main(String[] args) {
		HeapSort hSort = new HeapSort();
		
		int [] input = new int[] {2,4,6,3,5,1};
		
		hSort.heapSort(input);
		
		System.out.println("After Sort...");
		for(int i: input) {
			System.out.print(i+" ");
		}
		
	}
	

}
