package vic.kata;

public class TreeVisitor {
    public String visit(TreeNode node) {
        if (node.getLeft() != null) {
            return "AL";
        }
        return "A";
    }
}
