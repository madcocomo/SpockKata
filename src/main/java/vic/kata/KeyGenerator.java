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
        String properLengthClassName = getProperLengthClassName(className, method);
        return MessageFormat.format("{0}{1}.{2}", header, properLengthClassName, method);
    }

    private String getProperLengthClassName(String className, String method) {
        int length = header.length() + className.length() + method.length() + 1;
        if (length > this.length) {
            return classNameWithoutPackage(className);
        }
        return className;
    }

    private String classNameWithoutPackage(String className) {
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
