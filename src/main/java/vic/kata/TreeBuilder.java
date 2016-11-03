package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        return new TreeNode(text.split(",")[0], new TreeNode("L"));
    }
}
