import spock.lang.Specification
import vic.kata.KeyGenerator

class KeyGeneratorSpec extends Specification {
    def "Key should contents header, package, and method"() {
        given:
        KeyGenerator generator = new KeyGenerator("DBO\$", 40);
        when:
        String key = generator.genKey "my.package.Repository", "saveItem"
        then:
        key == "DBO\$my.package.Repository.saveItem"
    }

    def "Key should not longer than limitation"() {
        given:
        KeyGenerator generator = new KeyGenerator("DBO\$", 40);
        when:
        String key = generator.genKey "my.deep.deep.deep.package.Repository", "saveItem"
        then:
        key == "DBO\$Repository.saveItem"
    }
}