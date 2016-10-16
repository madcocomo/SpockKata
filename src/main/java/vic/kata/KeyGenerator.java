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
        int methodLimitation = this.length - header.length();
        return  header + getClassNameShorterThan(className, limitation) + getMethodShorterThan(method, methodLimitation);
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
