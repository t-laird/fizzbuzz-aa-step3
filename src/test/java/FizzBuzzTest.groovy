import spock.lang.Specification
import spock.lang.Unroll

class FizzBuzzTest extends Specification {
    def fizzBuzz = new FizzBuzz();

    @Unroll
    def "FizzBuzz"() {

        when:
        def res = fizzBuzz.fizzBuzz(start, end)

        then:
        res.resultStrings       == expectedStrings
        res.wordCounts.fizz     == expectedCounts.fizz
        res.wordCounts.buzz     == expectedCounts.buzz
        res.wordCounts.fizzbuzz == expectedCounts.fizzbuzz
        res.wordCounts.lucky    == expectedCounts.lucky
        res.wordCounts.integer  == expectedCounts.integer

        where:
        start | end | expectedStrings | expectedCounts
        1     | 20  | ["1", "2", "lucky", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "lucky", "14", "fizzbuzz", "16", "17", "fizz", "19", "buzz"] | [fizz: 4, buzz: 3, fizzbuzz: 1, lucky: 2, integer: 10]
        9     | 23  | ["fizz", "buzz", "11", "fizz", "lucky", "14", "fizzbuzz", "16", "17", "fizz", "19", "buzz", "fizz", "22", "lucky"] | [fizz: 4, buzz: 2, fizzbuzz: 1, lucky: 2, integer: 6]
    }
}
