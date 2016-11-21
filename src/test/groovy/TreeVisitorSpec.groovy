import spock.lang.Specification
import vic.kata.TreeBuilder
import vic.kata.TreeNode
import vic.kata.TreeVisitor

class TreeVisitorSpec extends Specification {
    TreeBuilder builder = new TreeBuilder()
    TreeVisitor visitor = new TreeVisitor();

    def "should return root text if single node"() {
        given:
        TreeNode root = builder.build "A"
        when:
        String actual = visitor.visit root
        then:
        actual == "A"
    }

    def "should return root-left text if has left"() {
        given:
        TreeNode root = builder.build "A,L"
        when:
        String actual = visitor.visit root
        then:
        actual == "AL"
    }
}
