package vic.kata;

import java.text.MessageFormat;

public class KeyGenerator {
    private String header;

    public KeyGenerator(String header, int length) {
        this.header = header;
    }

    public String genKey(String className, String method) {
        return MessageFormat.format("{0}{1}.{2}", header, className, method);
    }
}
