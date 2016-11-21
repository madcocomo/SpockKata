package vic.kata;

public class TreeVisitor {
    public String visit(TreeNode node) {
        String result = "";
        result += visitNode(node);
        result += visitNode(node.getLeft());
        result += visitNode(node.getRight());

        if (node.getLeft() != null) {
            result += visitNode(node.getLeft().getLeft());
        }
        return result;
    }

    private String visitNode(TreeNode node) {
        if (node != null) {
            return node.getText();
        }
        return "";
    }
}
