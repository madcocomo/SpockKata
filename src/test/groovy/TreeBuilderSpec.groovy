import spock.lang.Ignore
import spock.lang.Specification
import vic.kata.TreeBuilder
import vic.kata.TreeNode

class TreeBuilderSpec extends Specification {
    TreeBuilder builder = new TreeBuilder()

    def "should build root from single string"() {
        when:
        TreeNode root = builder.build("A")
        then:
        root.text == "A"
        root.left == null
        root.right == null
    }

    def "should set left child by 2nd string"() {
        when:
        TreeNode root = builder.build("A,L")
        then:
        root.text == "A"
        root.left.text == "L"
    }

    def "should set both left and right"() {
        when:
        TreeNode root = builder.build("A,L,R")
        then:
        root.text == "A"
        root.left.text == "L"
        root.right.text == "R"
    }

    def "that's alright with parentheses"() {
        when:
        TreeNode root = builder.build("(A)")
        then:
        root.text == "A"
    }

    def "deep left in parentheses"() {
        when:
        TreeNode root = builder.build("A,(L,LL,LR),R")
        then:
        root.left.text == "L"
        root.left.left.text == "LL"
    }

    def "deep left and right"() {
        when:
        TreeNode root = builder.build(
            "A,(L,LL,LR),(R,(RL,RLL,(RLR,RLRL)),(RR,RRL))")
        then:
        root.left.right.text == "LR"
        root.right.right.text == "RR"
        root.right.right.left.text == "RRL"
        root.right.right.right == null
    }

    def "should split 3, 2, or 1 parts"(String text, String[] parts) {
        expect:
        builder.tripleSplit(text) == parts
        where:
        text         || parts
        "A,B,C"      || ["A", "B", "C"]
        "A,B"        || ["A", "B", ""]
        "A"          || ["A", "", ""]
        "A,B,(C,C1)" || ["A", "B", "(C,C1)"]
        "A,B,(C,C1,(C2,C22))" || ["A", "B", "(C,C1,(C2,C22))"]
        "A,B,(C,(C1,C11),C2)" || ["A", "B", "(C,(C1,C11),C2)"]
        "A,(B,B1),C" || ["A", "(B,B1)", "C"]
        "A,B,(C,(C1,C11),(RR,RRL))" || ["A", "B", "(C,(C1,C11),(RR,RRL))"]
    }

}
