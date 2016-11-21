import spock.lang.Specification
import vic.kata.TreeBuilder
import vic.kata.TreeNode
import vic.kata.TreeVisitor

class TreeVisitorSpec extends Specification {

    def "should return root-left-right"(String preDfs, String expect) {
        given:
        TreeBuilder builder = new TreeBuilder()
        TreeVisitor visitor = new TreeVisitor();
        TreeNode root = builder.build preDfs
        when:
        String actual = visitor.visit root
        then:
        actual == expect
        where:
        preDfs  || expect
        "A"     || "A"
        "A,L"   || "AL"
        "A,L,R" || "ALR"
        "A,(L1,L2)" || "AL1L2"
        "A,(L1,L2),R" || "AL1RL2"
        "A,(L1,L2,L3)" || "AL1L2L3"
    }
}
