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
        "0A2B" || "43"   | "34"  | "2 digits, 2 position diff"
        "0A1B" || "433"  | "356" | "2 position diff digits match to 1"
        "1A0B" || "343"  | "356" | "1 position diff digits after full match"
        "1A0B" || "343"  | "563" | "1 position diff digits before full match"
        "1A0B" || "563"  | "343" | "reverse 1 position diff digits before full match"
        "1A3B" || "1807" | "7810"| "example test"
        "1A3B" || "7810" | "1807"| "reverse example test"
        "1A1B" || "1123" | "0111"| "example duplication test"
        "1A1B" || "0111" | "1123"| "reverse example duplication test"
    }

}
