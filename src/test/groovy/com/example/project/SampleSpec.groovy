import spock.lang.Specification

class SampleSpec extends Specification {

    def "validate string concatenation"() {

        given:
            // act
            def string1 = "hello"
            def string2 = "world!!"

        when:
            // arrange
            def stringConcatenated = string1.concat(string2)

        then:
            // assert
            stringConcatenated == "helloworld!!"
    }

    def "check case-insensitive equality of 2 strings"() {

        given: "two input strings"
            def str1 = "hello"
            def str2 = "HELLO"

        when: "strings are lowercased"
            str1 = str1.toLowerCase()
            str2 = str2.toLowerCase()
        
        then: "equal strings should return success"
            str1 == str2
    }
}