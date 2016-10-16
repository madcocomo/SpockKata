package vic.kata;

import java.text.MessageFormat;

public class KeyGenerator {
    private String header;
    private int length;

    public KeyGenerator(String header, int length) {
        this.header = header;
        this.length = length;
    }

    public String genKey(String className, String method) {
        String key = MessageFormat.format("{0}{1}.{2}", header, className, method);
        if (key.length() > length) {
            return MessageFormat.format("{0}{1}.{2}", header, classNameWithoutPackage(className), method);
        }
        return key;
    }

    private String classNameWithoutPackage(String className) {
        return className.substring(className.lastIndexOf(".")+1);
    }
}
