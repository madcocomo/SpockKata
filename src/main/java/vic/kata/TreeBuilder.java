package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        if (text.equals("")) return null;
        String[] texts = getTexts(text);
        return new TreeNode(texts[0], build(texts[1]), build(texts[2]));
    }

    private String[] getTexts(String text) {
        return tripleSplit(text.replaceAll("^\\(|\\)$",""));
    }

    public String[] tripleSplit(String text) {
        int i1 = text.indexOf(",");
        int i2 = getRightStartPoint(text);
        return cutToTriple(text, i1, i2);
    }

    private int getRightStartPoint(String text) {
        int result = text.lastIndexOf(",");

        if (text.endsWith(")")) {
            result = text.length();
            for (int i = text.length() - 1; text.charAt(i) == ')'; i--) {
                result = text.lastIndexOf(",(", result-1);
            }
        }
        return result;
    }

    private String[] cutToTriple(String text, int i1, int i2) {
        if (i1 <= 0) {
            return new String[]{text, "", ""};
        }
        String root = text.substring(0, i1);
        String left;
        if (i1 >= i2) {
            left = text.substring(i1 + 1);
            return new String[]{root, left, ""};
        }
        left = text.substring(i1 + 1, i2);
        String right = text.substring(i2 + 1);
        return new String[]{root, left, right};
    }
}
