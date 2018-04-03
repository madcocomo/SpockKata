import spock.lang.Specification
import spock.lang.Unroll
import vic.kata.MaximumNumberFrom2Arrays

//Leetcode 321
class MaximumNumberFrom2ArraysSpec extends Specification {
    @Unroll
    def "maximum number test length #k from #array1, #array2"() {
        when:
            def solution = new MaximumNumberFrom2Arrays()
            int[] actual = solution.maxNumberOf((int[])array1, (int[])array2, 1)
        then:
            actual == (int[])expected
        where:
            k | array1 | array2 || expected
            1 | [5]    | []     || [5]
            1 | [5,3]  | []     || [5]
    }

}
