package vic.kata;

public class KeyGenerator {
    final private String header;
    final private int length;

    public KeyGenerator(String header, int length) {
        this.header = header;
        this.length = length;
    }

    public String genKey(String className, String method) {
        int methodLimit = this.length - header.length();
        int classLimit = methodLimit - method.length() - 1;
        return  header + getClassNameShorterThan(className, classLimit) + getMethodShorterThan(method, methodLimit);
    }

    private String getMethodShorterThan(String method, int limitation) {
        if (method.length() > limitation) {
            return method.substring(0, limitation-2) + ".~";
        }
        return method;
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
