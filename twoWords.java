
/* Find how many characters you have to remove from two words in order 
to get only the letters that are included in both of them */

import java.util.*;


public class twoWords {
    public static int crossedCharacters(String first, String second){

    List<Character> listFirst = new ArrayList<>();
    List<Character> listSecond = new ArrayList<>();

    for (int i=0; i < first.length(); i++){
        listFirst.add(first.charAt(i));
    }
    for (int i=0; i < second.length(); i++){
        listSecond.add(second.charAt(i));
    }
    
    listFirst.retainAll(listSecond);

    int result = Math.abs((second.length() - listFirst.size()) + (first.length() - listFirst.size()));

    return result;


    }

    public static void main(String args []){
        System.out.println(twoWords.crossedCharacters("codewars", "hackerrank"));
    }

   
}