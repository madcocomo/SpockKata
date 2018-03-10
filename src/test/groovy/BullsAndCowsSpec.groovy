import spock.lang.Specification
import spock.lang.Unroll
import vic.kata.BullsAndCows

class BullsAndCowsSpec extends Specification {
    @Unroll
    def "will get hint '#expect' comparing #secret & #guess, #desc"() {
        expect:
        BullsAndCows.getHint(secret, guess) == expect
        where:
        expect || secret | guess | desc
        "0A0B" || "3"    | "4"   | "1 digit, different"
        "1A0B" || "3"    | "3"   | "1 digit, same"
        "1A0B" || "34"   | "35"  | "2 digits, 1 same"
        "1A0B" || "43"   | "53"  | "2 digits, 1 same, reverse"
        "2A0B" || "43"   | "43"  | "2 digits, all same"
        "0A1B" || "43"   | "32"  | "2 digits, 1 position diff"
    }

}
