package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        if (text.equals("")) return null;
        String[] parts = text.split(",");
        String root = parts[0];
        String left;
        if (parts.length > 1) {
            left = parts[1];
        } else {
            left = "";
        }
        return new TreeNode(root, build(left), null);
    }
}
