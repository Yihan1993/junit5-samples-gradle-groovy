import spock.lang.Specification
import com.example.project.CityInfo

class CityInfoTest extends Specification {

    def "setup"() {
        println "in setup"
    }

    def "assertion tips"() {

        given:
            def cityList = new LinkedList<CityInfo>()

        when:
            cityList.add(new CityInfo("London", 1000))
            cityList.add(new CityInfo("Hamburg",  500))
            cityList.add(new CityInfo("Paris",  1400))
        
        then:
            cityList*.cityName ==  ["London", "Hamburg", "Paris"]
    }

    def "cleanup"() {
        println "cleanup"
    }
}