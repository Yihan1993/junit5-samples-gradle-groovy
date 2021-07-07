import spock.lang.Specification
import com.example.project.IStudentDatabase
import com.example.project.StudentGradeCalculator

class SampleMockSpec extends Specification {

    //  instantiating mocks
    def mockedDatabase = Mock(IStudentDatabase.class)
    def app = new StudentGradeCalculator(mockedDatabase)

    def "sample mock based test"() {

        when:
        app.calculateStudentGrade("123")

        then:
        // validate interaction with mock
        1*mockedDatabase.getStudentGrade("123")
        1*mockedDatabase.getStudentScores("123")
        1*mockedDatabase.updateStudentGrade("123", "C")
    }

    // argument matcher

    def "argument matchers generic"() {

        when:
        app.calculateStudentGrade("123")

        then:
        // validate interaction with mock
        1*mockedDatabase.getStudentScores(_ as String)
        1*mockedDatabase.updateStudentGrade(_ as String, "C")
    }

    // to validate the order of interactions

    def "argument matchers generic with order validations"() {

        when:
        app.calculateStudentGrade("123")

        then:
        // validate interaction with mock
        1*mockedDatabase.getStudentScores(_ as String)
        
        then:
        1*mockedDatabase.updateStudentGrade(_ as String, "C")
    }
}