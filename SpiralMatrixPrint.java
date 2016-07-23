package prashanta.practice;

// http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpiralMatrixPrint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] m1 = {
        		
        					{ 1 , 2, 3, 4, 5 },
        					{ 6,7, 8, 9, 10 },
        					{ 11, 12, 13, 14, 15}
        				};
        
        System.out.println("NoOfRows::"+ m1.length);
        System.out.println("NoOfColomns::"+ m1[0].length);
        
        List<Integer> l1 = spiralOrder(m1);
        printList(l1);
        
        System.out.println("");
        int[][] m2 = {
        		
				{ 1 , 2 },
				{ 6,7},
				{ 11, 12}
			};
        List<Integer> l2 = spiralOrder(m2);
        printList(l2);
	}
	
	// http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
	public static List<Integer> spiralOrder(int[][] matrix){
		List<Integer> result = new ArrayList<Integer>();
		
		if(matrix == null || matrix.length == 0 || matrix[0].length== 0)
				return result;
		int m =  matrix.length ; // no of rows
		int n = matrix[0].length; // no of colomns
		
		int left=0;
		int right=n-1;
		int top=0;
		int bottom=m-1;
		
		while(result.size()<m*n){
			
			for(int j=left;j<=right;j++){
				result.add(matrix[top][j]);
			}
			top++;
			
			for(int i = top;i<=bottom;i++){
				result.add(matrix[i][right]);
			}
			right--;
			//  prevent duplicate row
			if(bottom<top)
				break;
			
			for(int i=right;i>=left;i--){
				result.add(matrix[bottom][i]);
			}
			bottom--;
			
			// prevent duplicate colomn
			if(right<left)
				break;
			
			for(int j=bottom;j>=top;j--){
				result.add(matrix[j][left]);
			}
			left++;
			
			
		}
		
		return result;
	}
   
	public static void printList(List l){
		Iterator<Integer> itr = l.iterator();
		while(itr.hasNext()){
			System.out.print(" " + itr.next());
		}
	}
}
