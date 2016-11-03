package vic.kata;

public class TreeNode {
    private String text;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String text, TreeNode left, TreeNode right) {
        this.text = text;
        this.left = left;
        this.right = right;
    }

    public String getText() {
        return text;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}

