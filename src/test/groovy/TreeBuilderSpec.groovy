import spock.lang.Specification
import vic.kata.TreeBuilder
import vic.kata.TreeNode

class TreeBuilderSpec extends Specification {
    def "should build root from single string"() {
        given:
        TreeBuilder builder = new TreeBuilder()
        when:
        TreeNode root = builder.build("A")
        then:
        root.text == "A"
    }
}
