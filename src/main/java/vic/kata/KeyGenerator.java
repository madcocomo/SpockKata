package vic.kata;

public class KeyGenerator {
    private String header;

    public KeyGenerator(String header) {
        this.header = header;
    }

    public String genKey(String className, String method) {
        return header + className + "." + method;
    }
}
