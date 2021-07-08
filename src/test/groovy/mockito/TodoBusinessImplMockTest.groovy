package mockito

import static groovy.test.GroovyAssert.*
import org.junit.Test
import mockito.*
import static org.mockito.Mockito.*


public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {

        // mock method is dynamic compare with stub method
        TodoService todoServiceMock = mock(TodoService.class)
        List<String> todos = Arrays.asList("Learn mockito", "Learn unit test")

        when(todoServiceMock.retrieveTodos("dummy")).thenReturn(todos)

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock)

        List<String> filteredTodos = todoBusinessImpl
            .retrieveTodosRelatedToSpring("dummy")

        assertEquals(2, filteredTodos.size())
    }
}      