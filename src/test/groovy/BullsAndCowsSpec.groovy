import spock.lang.Specification
import vic.kata.BullsAndCows

class BullsAndCowsSpec extends Specification {
    def "will get hint comparing secret & guess"() {
        expect:
        BullsAndCows.getHint(secret, guess) == expect
        where:
        expect || secret | guess | DESC
        "0A0B" || "3"    | "4"   | "1 digit, different"
        "1A0B" || "3"    | "3"   | "1 digit, same"
        "1A0B" || "34"   | "35"  | "2 digits, 1 same"
        "1A0B" || "43"   | "53"  | "2 digits, 1 same, reverse"
    }

}
