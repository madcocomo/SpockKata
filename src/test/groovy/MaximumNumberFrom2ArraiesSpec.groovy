import spock.lang.Specification
import spock.lang.Unroll
import vic.kata.MaximumNumberFrom2Arrays

//Leetcode 321
class MaximumNumberFrom2ArraysSpec extends Specification {
    @Unroll
    def "maximum number test length #k from #array1, #array2"() {
        when:
            def solution = new MaximumNumberFrom2Arrays()
            int[] actual = solution.maxNumberOf((int[])array1, (int[])array2, k)
        then:
            actual == (int[])expected
        where:
            k | array1  | array2 || expected
            1 | [5]     | []     || [5]
            1 | [5,3]   | []     || [5]
            1 | [3,5]   | []     || [5]
            2 | [3,5,2] | []     || [5,2]
            2 | [5,2]   | []     || [5,2]
            2 | [2,5]   | []     || [2,5]
            2 | [3,2,5] | []     || [3,5]
            1 | []      | [5]    || [5]
            2 | [3]     | [5]    || [5,3]
            2 | [5]     | [3]    || [5,3]
            3 | [3,9]   | [8]    || [8,3,9]
            3 | [6,4]   | [5]    || [6,5,4]
            3 | [4,9]   | [3,9]  || [9,4,9]
            3 | [3,9]   | [4,9]  || [9,4,9]
    }

}
