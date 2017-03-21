import java.util.*;
public class Quiz2Redux{  
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help(s, words, 0, "");
      Collections.sort(words);
      System.out.println(words);
      return words;
  }
    
    private static void help(String s, ArrayList<String> words, int index, String current){
	if(words.indexOf(current) == -1){
	    words.add(current);
	}
	if(index == s.length()){
	    return;
	}
	help(s, words, index + 1, current);
	help(s, words, index + 1, current + s.charAt(index));
  }

    public static void main(String[] a){
	combinations("abcabc!");
    }
	
}
