package RiaPack;
//http://java2novice.com/java-interview-programs/remove-duplicates-sorted-array/
/*public class MyDuplicateElements {
	 
    public static int[] removeDuplicates(int[] input){
         
        int j = 0;
        int i = 1;
        //return if the array length is less than 2
        if(input.length < 2){
            return input;
        }
        while(i < input.length){
            if(input[i] == input[j]){
                i++;
            }else{
                input[++j] = input[i++];
            }   
        }
        int[] output = new int[j+1];
        for(int k=0; k<output.length; k++){
            output[k] = input[k];
        }
         
        return output;
    }
     
    public static void main(String a[]){
        int[] input1 = {2,3,6,6,8,9,10,10,10,12,12};
        int[] output = removeDuplicates(input1);
        for(int i:output){
            System.out.print(i+" ");
        }
    }
}*/
public class RemoveDuplicateSortedArray {
	public static int[] removeDuplicatesNotInPlace(int[] input){
		int i=0;
		int j=0;
		int[] output = new int[input.length];
		while(i<input.length){
			if(input[i]==input[i+1]){
				i++;
			}
			else{
				output[j++] = input[i++];
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {2,3,6,6,8,9,10,10,10,12,12};
        int[] output = removeDuplicatesNotInPlace(input1);
        for(int i:output){
            System.out.print(i+" ");
        }

	}

}
