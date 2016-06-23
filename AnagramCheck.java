package RiaPack;



/*Thursday, March 21, 2013
How to check if two String are Anagram in Java - Program Example
Write a Java program to check if two String are anagram of each other, is another good coding question asked at fresher level Java Interviews. This question is on similar level of finding middle element of LinkedList in one pass and swapping two numbers without using temp variable. By the way two String are called anagram, if they contains same characters but on different order e.g. army and mary, stop and pots etc. Anagrams are actually mix-up of characters in String. If you are familiar with String API, i.e. java.lang.String than you can easily solve this problem. In order to check if  Strings are anagram, you need to get there character array and see if they are equal or not. Though you can also use indexOf(), substring() and StringBuffer or StringBuilder  class to solve this question. In this Java program, we will see 3 ways to solve this interview questions, and check if two String are anagram or not. By the way, if you are preparing for Java interview, it's good to prepare some data structures and algorithms questions as well. More often, there is one or more questions from programming, coding and logic in these interviews.


Java program to check if String is anagram
String Anagram Check - 3 ways to find if two Strings are anagrams or notAs I said, there are multiple ways to find if two string are anagram or not. Classical way is getting character array of each String, and then comparing them, if both char array is equal then Strings are anagram. But before comparing, make sure that both String are in same case e.g. lowercase or uppercase and character arrays are sorted, because equals method of Arrays, return true, only if array contains same length, and each index has same character. For simplicity, I have left checking if String is null or empty and converting them into uppercase or lowercase, you can do that if you want. If Interviewer ask you to write production quality code, then I would suggest definitely put those checks and throw IllegalArgumentException for null String or you can simply return false. I would personally prefer to return false rather than throwing Exception, similar to equals() method. Anyway, here are three ways to check if two String are Anagram or not. I have also included a JUnit Test to verify various String which contains both anagram and not.
*/
import java.util.Arrays;

/**
 * Java program - String Anagram Example.
 * This program checks if two Strings are anagrams or not
 *
 * @author Javin Paul
 */
public class AnagramCheck {
   
    /*
     * One way to find if two Strings are anagram in Java. This method
     * assumes both arguments are not null and in lowercase.
     *
     * @return true, if both String are anagram
     */
    public static boolean isAnagram(String word, String anagram){       
        if(word.length() != anagram.length()){
            return false;
        }
       
        char[] chars = word.toCharArray();
       
        for(char c : chars){
            int index = anagram.indexOf(c);
            if(index != -1){
                anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length());
            }else{
                return false;
            }           
        }
       
        return anagram.isEmpty();
    }
   
    /*
     * Another way to check if two Strings are anagram or not in Java
     * This method assumes that both word and anagram are not null and lowercase
     * @return true, if both Strings are anagram.
     */
    public static boolean iAnagram(String word, String anagram){
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();       
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
       
        return Arrays.equals(charFromWord, charFromAnagram);
    }
   
   
    public static boolean checkAnagram(String first, String second){
        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);
       
        for(char ch : characters){
            int index = sbSecond.indexOf("" + ch);
            if(index != -1){
                sbSecond.deleteCharAt(index);
            }else{
                return false;
            }
        }
       
        return sbSecond.length()==0 ? true : false;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(isAnagram("word","orwd"));
        
	}
}





//Read more: http://javarevisited.blogspot.com/2013/03/Anagram-how-to-check-if-two-string-are-anagrams-example-tutorial.html#ixzz3hHcD2idE

