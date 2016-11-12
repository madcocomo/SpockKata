package vic.kata;

public class TreeBuilder {

    public TreeNode build(String text) {
        if (text.equals("")) return null;
        String[] texts = getTexts(text);
        return new TreeNode(texts[0], build(texts[1]), build(texts[2]));
    }

    private String[] getTexts(String text) {
        String[] parts = text.replaceAll("[()]","").split(",");
        String[] texts = new String[]{"","",""};
        System.arraycopy(parts, 0, texts, 0, parts.length);
        return texts;
    }
}
