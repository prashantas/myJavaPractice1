package prashanta.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


class BigIntegerUse {
    public static void main(String args[] ) throws Exception {
        
         //Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
  //      long N = Integer.parseInt(line1);
        String line2 = br.readLine();
        long Q = Integer.parseInt(line2);
        //String tc = br.readLine();
        
        for(long i=1;i<=Q;i++){
			String line = br.readLine();
			String[] ln = line.split(" ");
			//char[] str = ln[0].toCharArray();
			int s = Integer.parseInt(ln[0]);
			int e = Integer.parseInt(ln[1]);
			BigInteger no = TestClass.getNumberIn(N, s, e);
			//if(no%7 == 0){
			if(no.mod(new BigInteger("7")) != null){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
			
			//System.out.println(N + ":"+ Q+":" + "s:"+s +"::e:"+ e);
		}      
       
    }
    
    public static BigInteger getNumberIn(String N,int s,int e ){
    	long no=0;
    	//String str = Long.toString(N);
    	//char[] chr = N.toCharArray();
    	String sub = N.substring(s-1, e);
    	System.out.println(sub);
    	//int pow = 0;
    	/*for( int k = (s-1); k<= (e-s+1);k++){
    		//char c = chr[k];
    		int d  = Integer.parseInt(String.valueOf(chr[k]));
    		no = d + no * 10;
    	}*/
    	
    	return new BigInteger(sub);
    }
}

