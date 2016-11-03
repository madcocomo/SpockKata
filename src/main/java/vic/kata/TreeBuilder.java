package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        String[] parts = text.split(",");
        String root = parts[0];
        if (text.contains(",")) {
            String left = parts[1];
            return new TreeNode(root, new TreeNode(left));
        }
        return new TreeNode(root);
    }
}
