package mockito

import java.util.Arrays
import java.util.List

public class TodoServiceStub implements TodoService {
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn mockito", "Learn unit test")
    }
}