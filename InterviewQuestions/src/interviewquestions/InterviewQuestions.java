/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewquestions;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jstuart15
 */
public class InterviewQuestions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        anagram();
        //numNotInSecondArray();
        
    }

    private static void fizzBuzz() {
        //1. Write a program that prints the numbers from 1 to 100. But for multiples 
        //   of three print "Fizz" instead of the number and for the multiples of five 
        //   print "Buzz". For numbers which are multiples of both three and five print 
        //   "FizzBuzz". 
        System.out.println("Running #1 FizzBuzz");
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + "-");
            if (i % 3 == 0) {
                System.out.print("Fizz");
            }
            if (i % 5 == 0) {
                System.out.print("Buzz");
            }
            System.out.println("");
        }
    }

    private static void palindrome() {
        //2. Check if a string is a palindrome. 
        System.out.println("Running #2 Palindrome");
        String text = "racecar";
        int textLength = text.length() - 1;
        Boolean isPalindrome = true;

        for (int i = 0; i < textLength / 2; i++) {
            if (text.charAt(i) != text.charAt(textLength - i)) {
                isPalindrome = false;
            }
        }
        System.out.println("It is " + isPalindrome + " that " + text + " is a palindrome");
    }

    private static void anagram() {
        //3. Check if two strings are anagrams 
        //An anagram is word or phrase formed by rearranging the letters of a
        //different word or phrase, typically using all the original letters 
        //exactly once.For example, the word anagram can be rearranged 
        //into "nag a ram".
        String s1 = "anagram";
        String s2 = "nag a ram";
        s2 = s2.replace(" ", "");

        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        
        Map<Character, Integer> lettersCountsArr1 = new HashMap<>();
        for (int i = 0; i < s1CharArray.length; i++) {
            
            
        }
        
    }

    private static void numNotInSecondArray() {
        //4. Given two arrays, find the number not in the second array 
        System.out.println("Two arrays, find number not in 2nd array; expect 3");
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,4,5};
        Boolean isMatch = false;
        int missingNum = -1;
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                isMatch = false;
                if(arr1[i] == arr2[j]){
                    isMatch = true;
                    break;
                }
            }
            if (isMatch == false ){
                missingNum = arr1[i];
                break;
            }
        }
        System.out.println("The missing number from array2 is " + missingNum);
    }
    
    

}

//5. Find the most frequent number in an array 
//6. Find the first non-repeated character in a String 
//7. Create an algorithm that will output the results of rolling a die (1-6) using a function that simulates a coin toss (1 or 2). All 6 outcomes should be equally likely. 
//8. Find the longest word in a sentence. 
//9. Print out all anagrams of a String
//10. Take an array and rotate it n spots
//11. Check if a string has balanced delimeters, opening and closing sides, returning true if it does.  Possible characters are []{}() -- "([]{})" is balanced but "([})" is not
//12. Given an array of numbers and a sum return true if there exists a pair of numbers that add up to the sum in the array.
//13. Write code to compute factorials.  
//	(3! = 3 x 2 x 1 = 6 or 7! = 7 x 6 x 5 x 4 x 3 x 2 x 1 = 5040)
//14. Reverse the words in a string
//15. Multiply function without using *
//16. Divide function without using /
//17. Given two number arrays return one array with only the unique numbers (no repeats in a single array)
//18. Given two number arrays return one array with only the duplicate numbers (no repeats in a single array)