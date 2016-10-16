import spock.lang.Specification
import vic.kata.KeyGenerator

class KeyGeneratorSpec extends Specification {
    def "Key Should contents header, package, and method"() {
        given:
        KeyGenerator generator = new KeyGenerator("DBO\$");
        when:
        String key = generator.genKey "my.package.Repository", "saveItem"
        then:
        key == "my.package.Repository.saveItem"
    }
}