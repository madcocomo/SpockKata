import spock.lang.Specification
import vic.kata.BullsAndCows

class BullsAndCowsSpec extends Specification {
    def "will get 0 bull comparing 3 & 4"() {
        expect:
        BullsAndCows.getHint("3", "4") == "0A0B"
    }

    def "will get 1 bull comparing 3 & 4"() {
        expect:
        BullsAndCows.getHint("3", "3") == "1A0B"
    }
}
