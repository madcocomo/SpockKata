package vic.kata;

import java.util.Arrays;
import java.util.List;

public class TreeVisitor {
    public String visit(TreeNode node) {
        String result = "";
        result += visitNode(node);
        List<TreeNode> visitLater;
        if (node != null) {
            visitLater = Arrays.asList(node.getLeft(), node.getRight());
            for (TreeNode child : visitLater) {
                result += visitNode(child);
            }
        }

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
