/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsyntax;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 *
 * @author jstuart15
 */
public class Lambdas {

    public static void main(String[] args) {

        //using the test method on a Predicate
        Predicate<String> stringLen = (s) -> s.length() < 10;
        System.out.println(stringLen.test("Apples") + " - Apples is less than 10");
        //prints "true - Apples is less than 10"

        //Consumer type uses accept method
        Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
        consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");
        //prints the string in all lowercase

        //Function example uses the .apply method       
        Function<Integer, String> converter = (num) -> Integer.toString(num);
        System.out.println("length of 26: " + converter.apply(26).length());
        //prints "length of 26: 2"

        //Supplier example using .get
        Supplier<String> s = () -> "Java is fun";
        System.out.println(s.get());
        //prints "Java is fun"

        //Binary Operator example
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("add 10 + 25: " + add.apply(10, 25));
        //prints "add 10 + 25: 35"

        //Unary Operator example
        UnaryOperator<String> str = (msg) -> msg.toUpperCase();
        System.out.println(str.apply("This is my message in upper case"));
        //prints THIS IS MY MESSAGE IN UPPER CASE

        //using an existing functional interface BiFunction         
        BiFunction<String, String, String> concat = (a, b) -> a + b;
        String sentence = concat.apply("Today is ", "a great day");
        System.out.println(sentence);
        //prints "Today is a great day"

        //example of the Consumer functional interface
        Consumer<String> hello = name -> System.out.println("Hello, " + name);
        for (String name : Arrays.asList("Duke", "Mickey", "Minnie")) {
            hello.accept(name);
        }
        /*Prints
            Hello, Duke
            Hello, Mickey
            Hello, Minnie
         */

        IntFunction<String> intToString = num -> Integer.toString(num);
        System.out.println("expected value 3, actual value: " + 
                intToString.apply(123).length());
     
        //static method reference using ::
        IntFunction<String> intToString2 = Integer::toString;
        System.out.println("expected value 4, actual value:  " + 
                intToString2.apply(4567).length());
        
        //lambdas made using a constructor
        Function<String,BigInteger> newBigInt = BigInteger::new;
        System.out.println("expected value: 123456789, actual value: "+ 
                newBigInt.apply("123456789"));
        
        Function<String,BigDecimal> newBigDec = BigDecimal::new;
        System.out.println("This function converts a string to BigDecimal " +
                newBigDec.apply("145.54"));
        
        //example of a lambda made from an instance method
        Consumer<String> print = System.out::println;
        print.accept("Coming to you directly from a lambda...");
        
        //these two are the same using the static method concat
        UnaryOperator<String> greeting = x -> "Hello, ".concat(x);
        System.out.println(greeting.apply("World"));
        
        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        System.out.println(makeGreeting.apply("Peggy"));
        
        //example of passing one value with custom functional interface
        GreetingFunction greeting1 = message
                -> System.out.println("Java Programming " + message);
        greeting1.sayMessage("Rocks with lambda expressions");
        //prints "Java Programming Rocks with lambda expressions"
}
        //custom functional interface
        @FunctionalInterface
        interface GreetingFunction {
            void sayMessage(String message);
        }
}
