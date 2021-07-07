import spock.lang.Specification
import com.example.project.Calculator

class CalculatorSpec extends Specification {
    def "sample parameterized tests for calculator addition"() {

        given:
        def cal = new Calculator()

        when:
        def result = cal.add(a, b)

        then:
        result == expectedOutput

        where:
        // data-driven testing -tables & <<
        // a | b | expectedOutput
        // 10 | 20| 30
        // -20 | 50| 30

        a << [10, 20]
        b << [-50, 30]
        expectedOutput << [-40, 50]
        
    }
}