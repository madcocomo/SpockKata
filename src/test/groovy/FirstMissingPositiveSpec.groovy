import spock.lang.Specification
import spock.lang.Unroll
import vic.kata.FirstMissingPositive

//Leetcode 41
class FirstMissingPositiveSpec extends Specification {
    @Unroll
    def "will be '#expect' from #numbers"() {
        expect:
        FirstMissingPositive.of(numbers as int[]) == expect
        where:
        expect || numbers
        1      || [0]
        2      || [1]
        2      || [3,1]
        3      || [2,1]
        3      || [2,5,1]
        3      || [2,-5,1]
        4      || [3,2,1]
        5      || [3,4,2,1]
    }

}
