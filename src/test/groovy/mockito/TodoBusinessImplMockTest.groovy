package mockito

import static groovy.test.GroovyAssert.*
import org.junit.Test
import mockito.*
import static org.mockito.Mockito.*
import org.mockito.Mockito


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


    @Test
	public void letsTestDeleteNow() {
		TodoService todoService = mock(TodoService.class)

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Happy functions")

		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos)

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService)

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga")

		verify(todoService).deleteTodo("Happy functions")

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC")

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring")

		verify(todoService, Mockito.times(1)).deleteTodo("Happy functions")
		// atLeastOnce, atLeast
    }
}      