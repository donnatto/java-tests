package com.donnatto.javatests.util;

public class FizzBuzz {

    public static String fizzBuzz(Integer n) {

        return n % 3 == 0 ? (n % 5 == 0 ? "FizzBuzz" : "Fizz") : (n % 5 == 0 ? "Buzz" : n.toString());

    }
}
