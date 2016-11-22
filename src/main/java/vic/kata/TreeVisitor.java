package vic.kata;

import java.util.ArrayList;
import java.util.List;

public class TreeVisitor {
    public String visit(TreeNode node) {
        String result = "";
        List<TreeNode> visitLater = new ArrayList<>();
        result += visitNode(node, visitLater);
        if (node != null) {
            for (int i = 0; i < visitLater.size(); i++) {
                TreeNode child = visitLater.get(i);
                result += visitNode(child, visitLater);
            }
        }
        return result;
    }

    private String visitNode(TreeNode node, List<TreeNode> visitLater) {
        if (node != null) {
            visitLater.add(node.getLeft());
            visitLater.add(node.getRight());
            return node.getText();
        }
        return "";
    }

}
