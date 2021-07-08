package mockito

import mockito.*
import org.junit.Test
import static org.mockito.BDDMockito.*
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*

public class TodoBusinessImplBDDMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() {

        // Given
        TodoService todoServiceMock = mock(TodoService.class)
        List<String> todos = Arrays.asList("Learn mockito", "Learn unit test")

        given(todoServiceMock.retrieveTodos("dummy")).willReturn(todos)

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(
            todoServiceMock)

        // When
        List<String> filteredTodos = todoBusinessImpl
            .retrieveTodosRelatedToSpring("dummy")

        // Then
        assertThat(filteredTodos.size(), is(2))
    }
}      