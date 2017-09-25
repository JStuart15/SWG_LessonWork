/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsyntax;

/**
 *
 * @author jstuart15
 */
public class Strings {

    public static void main(String[] args) {
        String test = "This is a sentence that we can perform multiple operations on.";
        System.out.println(test);
        
        //parse the elements of the string into an array
        String[] testArray = test.split(" ");
        System.out.println("We can split the string into an array using .split() and print each element of the array.");
        for (String s : testArray){
            System.out.println(s);
        }
        
        //length of string
        System.out.println("We can get the length of the string using .length()" + test.length());
    }

}
