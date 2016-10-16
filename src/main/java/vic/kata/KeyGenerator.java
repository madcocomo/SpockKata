package vic.kata;

public class KeyGenerator {
    private String header;
    private int length;

    public KeyGenerator(String header, int length) {
        this.header = header;
        this.length = length;
    }

    public String genKey(String className, String method) {
        int limitation = this.length - header.length() - method.length() - 1;
        return  header + getClassNameShorterThan(className, limitation) + method;
    }

    private String getClassNameShorterThan(String className, int limitation) {
        if (className.length() > limitation) {
            className = classNameWithoutPackage(className);
        }
        if (className.length() > limitation) {
            return "";
        }
        return className + ".";
    }

    private String classNameWithoutPackage(String className) {
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
