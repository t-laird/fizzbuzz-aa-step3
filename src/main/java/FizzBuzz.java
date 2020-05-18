import Exeptions.FizzBuzzException;
import Objects.FizzBuzzResult;
import Objects.WordCounts;
import Utilities.FizzBuzzLogger;
import Utilities.FizzBuzzUtil;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class FizzBuzz {

    public static void main(String[] args) throws FizzBuzzException {
        int start = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);

        FizzBuzzResult result = fizzBuzz(start, end);

        FizzBuzzLogger.printResult(result);
    }

    private static FizzBuzzResult fizzBuzz(int start, int end) throws FizzBuzzException {
        FizzBuzzUtil.validateInputs(start, end);

        List<String> fizzBuzzStrings = FizzBuzzUtil.createRange(start, end).stream()
                .map(FizzBuzzUtil::getFizzBuzzStringForNum)
                .collect(Collectors.toList());

        WordCounts wordCounts = FizzBuzzUtil.getWordCounts(fizzBuzzStrings);

        return FizzBuzzResult.builder()
                .resultStrings(fizzBuzzStrings)
                .wordCounts(wordCounts)
                .build();
    }
}
