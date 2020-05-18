package Utilities;


import Objects.FizzBuzzResult;

public class FizzBuzzLogger {

    public static void printResult(FizzBuzzResult result) {
        System.out.println(result.getResultStrings().toString());
        System.out.println(result.getWordCounts().toString());
    }
}
