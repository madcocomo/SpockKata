package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        if (text.equals("")) return null;
        String[] parts = text.split(",");
        String root = parts[0];
        String left = "";
        String right = "";
        if (parts.length > 1) {
            left = parts[1];
        }
        if (parts.length > 2) {
            right = parts[2];
        }
        return new TreeNode(root, build(left), build(right));
    }
}
