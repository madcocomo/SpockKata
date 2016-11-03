package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        String[] parts = text.split(",");
        String root = parts[0];
        TreeNode leftNode;
        if (text.contains(",")) {
            leftNode = build(parts[1]);
        } else {
            leftNode = null;
        }
        return new TreeNode(root, leftNode);
    }
}
