package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        String[] parts = text.split(",");
        String root = parts[0];
        TreeNode leftNode = null;
        if (text.contains(",")) {
            leftNode = new TreeNode(parts[1]);
            return new TreeNode(root, leftNode);
        }
        return new TreeNode(root, leftNode);
    }
}
