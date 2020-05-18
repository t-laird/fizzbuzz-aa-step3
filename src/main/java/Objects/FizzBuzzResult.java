package Objects;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FizzBuzzResult {

    private final List<String> resultStrings;
    private final WordCounts wordCounts;

}

