package mockito

import static groovy.test.GroovyAssert.*
import org.junit.Test
import mockito.*

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub() {
        TodoService todoServiceStub = new TodoServiceStub()

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub)

        List<String> filteredTodos = todoBusinessImpl
            .retrieveTodosRelatedToSpring("dummy")

        assertEquals(2, filteredTodos.size())
    }
}