package vic.kata;

public class TreeVisitor {
    public String visit(TreeNode node) {
        String result = "";
        result += visitNode(node);
        result += visitChildren(node);

        result += visitChildren(node.getLeft());
        result += visitChildren(node.getRight());

        if (node.getLeft() != null) {
            result += visitChildren(node.getLeft().getLeft());
        }
        return result;
    }

    private String visitNode(TreeNode node) {
        if (node != null) {
            return node.getText();
        }
        return "";
    }

    private String visitChildren(TreeNode node) {
        String result = "";
        if (node != null) {
            result += visitNode(node.getLeft());
            result += visitNode(node.getRight());
        }
        return result;
    }
}
