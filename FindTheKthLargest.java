/**
 * https://chinmaylokesh.wordpress.com/2011/03/01/order-statistics-general-find-the-kth-smallest-element-from-an-unsorted-array-in-linear-time-specific-find-median-of-unsorted-array-in-linear-time/p
 */
package RiaPack;

import java.util.Arrays;

public class FindTheKthLargest {
	
	public static int find(int [] sourceArray, int k){
		int[] less = new int[sourceArray.length];
		int[] greater = new int[sourceArray.length];
		int l=0,g=0;
		int pivot= sourceArray[0];
		for (int i = 0; i < sourceArray.length; i++) {
			if(sourceArray[i]< pivot){
				less[l++] = sourceArray[i];
			}else if(sourceArray[i]> pivot){
				greater[g++] = sourceArray[i];
			}
		}			
		/*   // for kth smallest
		if(k<=l){
			return find(Arrays.copyOf(less, l),k);
		}
		if(k>(sourceArray.length-g)){
			return find(Arrays.copyOf(greater, g), k - (sourceArray.length-g));
		}else{
			return pivot;
		}
		*/
		// Below is for kth largest
		if(k<=g){
			return find(Arrays.copyOf(greater, g),k);
		}
		if(k>(g+1)){
			return find(Arrays.copyOf(less, l),k-(g+1));
		}
		else return pivot;
	}
	public static void main(String[] args) {
		int[] testArray = {10,12,15,1,7,8,22};
		int K =4;
		System.out.println(K+"th largest no is :" +find(testArray, K));

	}

}
