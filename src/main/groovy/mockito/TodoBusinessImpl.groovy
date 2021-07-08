package mockito

import java.util.ArrayList
import java.util.List

// TodoBusinessImpl SUT(System under test)
// TodoService Dependency
public class TodoBusinessImpl {
	private TodoService todoService

	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>()
		List<String> allTodos = todoService.retrieveTodos(user)
		for (String todo : allTodos) {
			if (todo.contains("Learn")) {
				filteredTodos.add(todo)
			}
		}
		return filteredTodos
	}
}