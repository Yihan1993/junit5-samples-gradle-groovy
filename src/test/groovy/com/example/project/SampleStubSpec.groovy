import spock.lang.Specification
import com.example.project.IStudentDatabase
import com.example.project.StudentGradeCalculator

class SampleStubSpec extends Specification {

    //  instantiating stubs
    def studentDatabaseStub = Stub(IStudentDatabase.class)
    def app = new StudentGradeCalculator(studentDatabaseStub)

    def "sample stub test"() {
        given:
        studentDatabaseStub.getStudentGrade("123") >> "A"

        when:
        def grade = app.calculateStudentGrade("123")

        then:
        grade == "A"
    }

    def "sample stub test - 2"() {
        given:
        studentDatabaseStub.getStudentGrade("123") >> null
        studentDatabaseStub.getStudentScores("123") >> [40F, 40F, 15F]

        when:
        def grade = app.calculateStudentGrade("123")

        then:
        grade == "A"
    }

}
