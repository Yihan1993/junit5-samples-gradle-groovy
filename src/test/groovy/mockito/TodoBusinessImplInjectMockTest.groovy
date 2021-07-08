package mockito

import mockito.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner
import static org.mockito.Mockito.*
import static groovy.test.GroovyAssert.*

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplInjectMockTest {

    @Mock
    TodoService todoServiceMock

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl

    @Test
    public void testRetrieveTodosRelatedToSpring() {

        // mock method is dynamic compare with stub method
        List<String> todos = Arrays.asList("Learn mockito", "Learn unit test")

        when(todoServiceMock.retrieveTodos("dummy")).thenReturn(todos)

        List<String> filteredTodos = todoBusinessImpl
            .retrieveTodosRelatedToSpring("dummy")

        assertEquals(2, filteredTodos.size())
    }


    @Test
	public void letsTestDeleteNow() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Happy functions")

		when(todoServiceMock.retrieveTodos("Ranga")).thenReturn(allTodos)

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga")

		verify(todoServiceMock).deleteTodo("Happy functions")

		verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring MVC")

		verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring")

		verify(todoServiceMock, Mockito.times(1)).deleteTodo("Happy functions")
    }
}      