package vic.kata;

public class TreeVisitor {
    public String visit(TreeNode node) {
        String result = node.getText();
        if (node.getLeft() != null) {
            result += node.getLeft().getText();
        }
        if (node.getRight() != null) {
            result += node.getRight().getText();
        }
        return result;
    }
}
