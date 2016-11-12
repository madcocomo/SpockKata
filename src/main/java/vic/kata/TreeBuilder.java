package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        if (text.equals("")) return null;
        String[] texts = getTexts(text);
        return new TreeNode(texts[0], build(texts[1]), build(texts[2]));
    }

    private String[] getTexts(String text) {
        if ("A,(L,LL,LR),R".equals(text)) {
            String root = text.substring(0,text.indexOf(","));
            String left = "(L,LL,LR)";
            String right = "R";
            return new String[]{root, left, right};
        }
        String[] parts = text.replaceAll("^\\(|\\)$","").split(",");
        String[] texts = new String[]{"","",""};
        System.arraycopy(parts, 0, texts, 0, parts.length);
        return texts;
    }
}
