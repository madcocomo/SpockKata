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
    }

    def "should set left child by 2nd string"() {
        when:
        TreeNode root = builder.build("A,L")
        then:
        root.text == "A"
        root.left.text == "L"
    }
}
