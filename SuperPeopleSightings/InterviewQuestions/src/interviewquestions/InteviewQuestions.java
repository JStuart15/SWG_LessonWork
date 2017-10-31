package interviewquestions;


import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jstuart15
 */
public class InteviewQuestions {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = {0, 1, 3, 4};
        int num = 0;
        Boolean foundMatch;

        for (int i = 0; i < arr1.length; i++) {
            foundMatch = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.println("I'm in the equal if i and j are: " + i + j);
                    foundMatch = true;
                    break;
                }
            }
            if (foundMatch == false) {
                num = i;
            }
        }
        System.out.println(num);

        //find out if two words are anagrams
        String word1 = "Dog";
        String word2 = "god";
        System.out.println(word1.charAt(0));
        
        
        //#5 find the most frequent number in an array
        //given 1,2,1,1,2,4,8, which number shows the most is 1
        int[] nums = {1,2,1,1,2,4,8};
        int count = 0;
        
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            if(intMap.containsKey(i)){
                intMap.put(i, intMap.get(i) + 1);
            } else{
                intMap.put(i,1);
            }
        }
        System.out.println(intMap.toString());
        //cycle through the map to find the highest value

        //#X Given string return true if it is the same backwards and forwards, no white space
        String pal = "racecar";
        
        int lengthOfString = pal.length();
        System.out.println(lengthOfString);
        Boolean palindrome = true;
        System.out.println(pal.charAt(6));
        for (int beginning = 0; beginning<lengthOfString; beginning++){
            if (pal.charAt(beginning) != pal.charAt(lengthOfString-beginning)){
                palindrome = false;
            }
        }
        System.out.println("the word " + pal + "is a palindrome " + palindrome);
    }

}
