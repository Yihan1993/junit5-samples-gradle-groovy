import spock.lang.Specification
import com.example.project.IStudentDatabase
import com.example.project.StudentGradeCalculator

class SampleMockSpec extends Specification {

    //  instantiating mocks
    def mockedDatabase = Mock(IStudentDatabase.class)
    def app = new StudentGradeCalculator(mockedDatabase)

    def "sample mock based test"() {

        given:

        when:
            app.calculateStudentGrade("12345")

        then:
            // validate interaction with mock
            1*mockedDatabase.getStudentScores("12345")
            1*mockedDatabase.updateStudentGrade("12345", "C")
    }

    // argument matcher

    def "argument matchers generic"() {

        given:

        when:
            app.calculateStudentGrade("12345")

        then:
            // validate interaction with mock
            1*mockedDatabase.getStudentScores(_ as String)
            1*mockedDatabase.updateStudentGrade(_ as String, "C")
    }

    // to validate the order of interactions

    def "argument matchers generic with order validations"() {

        given:

        when:
            app.calculateStudentGrade("12345")

        then:
            // validate interaction with mock
            1*mockedDatabase.getStudentScores(_ as String)
        
        then:
            1*mockedDatabase.updateStudentGrade(_ as String, "C")
    }
}