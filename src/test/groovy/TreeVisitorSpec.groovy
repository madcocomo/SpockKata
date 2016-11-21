import spock.lang.Specification
import vic.kata.TreeBuilder
import vic.kata.TreeNode
import vic.kata.TreeVisitor

class TreeVisitorSpec extends Specification {
    def "should return return root text if single node"() {
        given:
        TreeBuilder builder = new TreeBuilder()
        TreeNode root = builder.build "A"
        TreeVisitor visitor = new TreeVisitor();
        when:
        String actual = visitor.visit root
        then:
        actual == "A"
    }
}
