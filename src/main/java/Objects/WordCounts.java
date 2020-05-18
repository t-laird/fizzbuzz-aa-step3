package Objects;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class WordCounts {
    private final int fizz;
    private final int buzz;
    private final int fizzbuzz;
    private final int lucky;
    private final int integer;
}
