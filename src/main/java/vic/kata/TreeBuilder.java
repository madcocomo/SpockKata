package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        if (text.contains(","))
            return new TreeNode(text.split(",")[0], new TreeNode(text.split(",")[1]));
        return new TreeNode(text);
    }
}
