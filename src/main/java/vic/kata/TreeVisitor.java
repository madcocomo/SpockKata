package vic.kata;

import java.util.ArrayList;
import java.util.List;

public class TreeVisitor {
    public String visit(TreeNode node) {
        List<TreeNode> visitLater = new ArrayList<>();
        String result = visitNode(node, visitLater);
        for (int i = 0; i < visitLater.size(); i++) {
            result += visitNode(visitLater.get(i), visitLater);
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
