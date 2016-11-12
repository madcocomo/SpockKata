package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        if (text.equals("")) return null;
        String[] texts = getTexts(text);
        return new TreeNode(texts[0], build(texts[1]), build(texts[2]));
    }

    private String[] getTexts(String text) {
        if ("A,(L,LL,LR),R".equals(text)) {
            int i1 = text.indexOf(",");
            int i2 = text.lastIndexOf(",");
            String root = text.substring(0, i1);
            String left = text.substring(i1 + 1, i2);
            String right = text.substring(i2 + 1);
            return new String[]{root, left, right};
        }
        String[] parts = text.replaceAll("^\\(|\\)$","").split(",");
        String[] texts = new String[]{"","",""};
        System.arraycopy(parts, 0, texts, 0, parts.length);
        return texts;
    }
}
