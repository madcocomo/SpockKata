package vic.kata;

public class TreeNode {
    private String text;
    private TreeNode left;

    public TreeNode(String text, TreeNode left) {
        this.text = text;
        this.left = left;
    }

    public String getText() {
        return text;
    }

    public TreeNode getLeft() {
        return left;
    }
}
