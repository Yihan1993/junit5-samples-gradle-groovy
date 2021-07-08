package mockito

import org.junit.Test
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*
import static org.hamcrest.Matchers.*

public class HamcrestMatchersTest {

    @Test
    public void test() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105)

        // scores has 4 items
        assertThat(scores, hasSize(4))
        assertThat(scores, hasItems(99, 100))
        assertThat(scores, everyItem(greaterThan(90)))
        assertThat(scores, everyItem(lessThan(110)))


        assertThat("", isEmptyString())
        assertThat(null, isEmptyOrNullString())

        // Arrays
        Integer[] marks = [1, 2, 3]

        assertThat(marks, arrayWithSize(3))
        assertThat(marks, arrayContaining(1, 2, 3))
        assertThat(marks, arrayContainingInAnyOrder(2, 1, 3))
    }
}