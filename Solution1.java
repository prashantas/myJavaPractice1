mport java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
* Complete the function below.
 */

    static int sum(int[] numbers) {
        int sum =0;
        for(int i=0;i<numbers.length;i++){
            sum = sum + numbers[i];
        }
        
        return sum;

    }
   public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _numbers_size = 0;
        _numbers_size = Integer.parseInt(in.nextLine().trim());
        int[] _numbers = new int[_numbers_size];
        int _numbers_item;
        for(int _numbers_i = 0; _numbers_i < _numbers_size; _numbers_i++) {
            _numbers_item = Integer.parseInt(in.nextLine().trim());
            _numbers[_numbers_i] = _numbers_item;
        }
        
        res = sum(_numbers);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }
  }
