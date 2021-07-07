import spock.lang.Specification
import com.example.project.StudentDatabase
import com.example.project.StudentGradeCalculator



class SampleSpySpec extends Specification {

    // instantiating spys
    def studentDatabaseSpy = Spy(StudentDatabase.class)
    def app = new StudentGradeCalculator(studentDatabaseSpy)

    def "sample spy test"() {

        when:
        app.calculateStudentGrade("123")

        then:
        1*studentDatabaseSpy.getStudentGrade("123")
        0*studentDatabaseSpy.getStudentScores(_ as String)
    }
}
