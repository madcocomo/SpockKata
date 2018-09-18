import spock.lang.Specification
import vic.kata.FirstMissingPositive

//Leetcode 41
class FirstMissingPositiveSpec extends Specification {
    def "will be '#expect' from #numbers"() {
        expect:
        FirstMissingPositive.of(numbers as int[]) == expect
        where:
        expect || numbers
        1      || [0]
        2      || [1]
    }

}
