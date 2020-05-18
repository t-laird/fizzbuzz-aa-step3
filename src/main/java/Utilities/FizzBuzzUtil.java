package Utilities;

import Constants.FizzBuzzConstants;
import Exeptions.FizzBuzzException;
import Objects.WordCounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FizzBuzzUtil {
    public static void validateInputs(int start, int end) throws FizzBuzzException {
        if (start > end) {
            throw new FizzBuzzException("Invalid Range");
        }
    }

    public static List<Integer> createRange(int start, int end) {
        List<Integer> nums = new ArrayList<>();

        for (int i = start ; i <= end ; i++) {
            nums.add(i);
        }

        return nums;
    }

    public static String getFizzBuzzStringForNum(int num) {
        if (isLucky(num)) {
            return FizzBuzzConstants.LUCKY;
        } else if (num % 15 == 0) {
            return FizzBuzzConstants.FIZZBUZZ;
        } else if (num % 3 == 0) {
            return FizzBuzzConstants.FIZZ;
        } else if (num % 5 == 0) {
            return FizzBuzzConstants.BUZZ;
        } else {
            return String.valueOf(num);
        }
    }

    private static boolean isLucky(int num) {
        return String.valueOf(num).contains("3");
    }

    public static WordCounts getWordCounts(List<String> fizzBuzzStrings) {
        Map<String, Long> wordMap = fizzBuzzStrings.stream()
                .collect(groupingBy((i) -> {
                    if (FizzBuzzConstants.resultTypes.contains(i)) {
                        return i;
                    } else {
                        return "integer";
                    }
                }, counting()));

        return WordCounts.builder()
                .buzz(Optional.ofNullable(wordMap.get("buzz")).orElse(0L).intValue())
                .fizz(Optional.ofNullable(wordMap.get("fizz")).orElse(0L).intValue())
                .fizzbuzz(Optional.ofNullable(wordMap.get("fizzbuzz")).orElse(0L).intValue())
                .lucky(Optional.ofNullable(wordMap.get("lucky")).orElse(0L).intValue())
                .integer(Optional.ofNullable(wordMap.get("integer")).orElse(0L).intValue())
                .build();
    }
}
