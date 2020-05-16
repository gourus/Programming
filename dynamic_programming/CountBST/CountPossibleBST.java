package dynamic_programming.CountBST;

/**
 * 
 * This program to count the maximum possible BSTs we can generate for a given number.
 * 
 * For example, n = 1; We can generate only one BST that is root as 1.
 * For n = 2; 
 * 
 * Then we can have 2 roots - root as 1 and root as 2.
 * Possible BSTs are - 2
 * 		
 * 		1			2
 *		 \	  +	   /
 *		  2		  1
 *	-----------------------------
 *		1	  +		1	= 	2
 *	-----------------------------
 * For n = 3;
 * 
 *  1				2			3
 *   \		 + 	   / \	 +	   /
 *   {2 , 3}	  1   3		 {1 , 2}
 * -----------------------------------------  
 *   2		 +		1	 +		2	= 	5
 * -----------------------------------------
 * 
 * {2 , 3} and {1, 2} are BSTs with max number of 2 variables. We have the output in 
 * previous result. i.e. 2 for each.
 *   
 * For n = 4;
 * 
 *  1			   2			 3			  4
 *   \		 + 	  / \	   +   /   \    +    /
 *   {2,3,4}	 1  {3,4}	 {1,2}  4	  {1,2,3}
 *  
 *  Now we will find out in formula manner.
 * --------------------------------------------------------
 *  1 * 5    +    1 * 2	   +  2 * 1	    +   5 * 1   =   14
 * --------------------------------------------------------    
 *   
 *  Now here, we need to solve the possible BSTs for 3 and 2. We also have them.
 *  
 *  NOTE: If a node is empty, we can have one BST (i.e. If n=0; f(0) = 1)
 *  
 *  If f(n) is a function, that gives the Max Number of possible BSTs, 
 *  From the above pattern, We can see as,
 *  
 *  For n = 4;
 *  
 *  f(4) = f(0)*f(3) + f(1)*f(2) + f(2)*f(1) + f(3)*f(0)
 *  
 *  So, we can genaralize the formula as
 *  
 *	   ****************************************************
 *	   * f(n) = sum( f(i)*f(n-i-1) ) For All i = 0 to n-1 *
 *	   ****************************************************
 *  
 * @author sgouru
 *
 */

public class CountPossibleBST {
	
	/**
	 * We are going to use the dynamic programming - why?
	 * 
	 * Because, if we see the pattern from the above description, 
	 * One problem is divided into sub problem. And it is dependent on 
	 * previous sub problems.
	 * 
	 * We are just writing a program for generalized formula above.
	 * 
	 * @param n
	 * @return
	 */
	public int countNumberOfBSTs(int n) {
		
		// Create a DP array with size of n+1.
		int [] f = new int[n+1];
		
		// We can create 1 BST with number of nodes as ZERO
		f[0] = 1;
		
		// We need to find the sum for each and every root
		for(int node = 1; node <= n; node++) {
			int root_sum = 0;
			// This loop is to calculate Number of BSTs for each root
			for(int index = 0; index < node; index++) {
				root_sum += f[index] * f[node-index-1];
			}
			f[node] = root_sum;
		}
		
		return f[n];
	}
	
	public static void main(String[] args) {
		
		CountPossibleBST cbst = new CountPossibleBST();
		
		System.out.println(cbst.countNumberOfBSTs(3));
		System.out.println(cbst.countNumberOfBSTs(4));
		System.out.println(cbst.countNumberOfBSTs(5));
		System.out.println(cbst.countNumberOfBSTs(6));
	}
	

}
