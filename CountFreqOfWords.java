
// count the frequency of each word in a given file

package prashanta.practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountFreqOfWords {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader ( new FileReader("c:/PRASHANTA/count.txt"));
		String line = null;
		Map<String,Integer> map = new HashMap<>();
		
		
		while((line = br.readLine())!=null){
			String[] words = line.split("[ \t\n\r.,;:{}()]");
			
			for(int c=0;c<words.length;c++){
				String key = words[c].toLowerCase();
				if(key.length()>0){
					if(map.get(key)==null){
						map.put(key, 1);
					}
					else{
						map.put(key, map.get(key)+1);
					}
				}
				
			}
			
		}
		
		for(String k: map.keySet()){
			System.out.println(k +"::" + map.get(k));
		}

	}

}
