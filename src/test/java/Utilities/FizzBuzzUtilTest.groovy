package Utilities

import Constants.FizzBuzzConstants
import Exeptions.FizzBuzzException
import spock.lang.Specification
import spock.lang.Unroll

class FizzBuzzUtilTest extends Specification {

    def "Validates Range Inputs - Valid Case"() {
        given:
        def start = 1
        def end = 100

        when:
        FizzBuzzUtil.validateInputs(start, end)

        then:
        noExceptionThrown()
    }

    def "Validates Range Inputs - Invalid Case"() {
        given:
        def start = 5
        def end = 1

        when:
        FizzBuzzUtil.validateInputs(start, end)

        then:
        def exc = thrown(FizzBuzzException)
        exc.message == "Invalid Range"
    }

    @Unroll
    def "createRange - #start - #end"() {
        when:
        def res = FizzBuzzUtil.createRange(start, end)

        then:
        res == expectation

        where:
        start   |   end   |   expectation
        1       |   3     |   [1, 2, 3]
        8       |   14    |   [8, 9, 10, 11, 12, 13, 14]
    }

    @Unroll
    def "getFizzBuzzStringForNum - #num"() {
        when:
        def fbString = FizzBuzzUtil.getFizzBuzzStringForNum(num)

        then:
        fbString == expectation

        where:
        num   |  expectation
        3     |  FizzBuzzConstants.LUCKY
        5     |  FizzBuzzConstants.BUZZ
        15    |  FizzBuzzConstants.FIZZBUZZ
        23    |  FizzBuzzConstants.LUCKY
        6     |  FizzBuzzConstants.FIZZ
        10    |  FizzBuzzConstants.BUZZ
        30    |  FizzBuzzConstants.LUCKY
        37    |  FizzBuzzConstants.LUCKY
        41    |  "41"
    }

    @Unroll
    def "isLucky - #num"() {
        when:
        def isLucky = FizzBuzzUtil.isLucky(num)

        then:
        isLucky == expectation

        where:
        num   |  expectation
        3     |  true
        4     |  false
        13    |  true
        39    |  true
        1003  |  true
    }

    @Unroll
    def "getWordCounts"() {
        when:
        def wordCount = FizzBuzzUtil.getWordCounts(results)

        then:
        wordCount.fizz     == expectedFizz
        wordCount.buzz     == expectedBuzz
        wordCount.fizzbuzz == expectedFizzBuzz
        wordCount.lucky    == expectedLucky
        wordCount.integer  == expectedIntegers

        where:
        results | expectedFizz | expectedBuzz | expectedFizzBuzz | expectedLucky | expectedIntegers
        ["1", "2", "lucky", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "lucky", "14", "fizzbuzz", "16", "17", "fizz", "19", "buzz"] | 4 | 3 | 1 | 2 | 10
        ["4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "lucky", "14", "16", "17", "fizz", "19", "buzz"] | 4 | 3 | 0 | 1 | 8
    }
}
