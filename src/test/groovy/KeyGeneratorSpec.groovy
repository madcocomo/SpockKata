import spock.lang.Specification
import vic.kata.KeyGenerator

class KeyGeneratorSpec extends Specification {
    def "Key should not longer than limitation"() {
        given:
        KeyGenerator generator = new KeyGenerator("DBO\$", 40);
        when:
        String key = generator.genKey className, method
        then:
        key == expect
        where:
        className                                   |method         ||expect
        "5678901234567890123456789"                 |"1234567890"   ||"DBO\$5678901234567890123456789.1234567890"
        "my.package.Repository"                     |"saveItem"     ||"DBO\$my.package.Repository.saveItem"
        "my.deep.deep.deep.package.Repository"      |"saveItem"     ||"DBO\$Repository.saveItem"
        "my.package.VeryVeryVeryLoooooogClassName"  |"saveItem"     ||"DBO\$saveItem"
    }
}