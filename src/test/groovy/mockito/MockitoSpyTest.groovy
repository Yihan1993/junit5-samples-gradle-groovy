package mockito

import org.junit.Test
import java.util.ArrayList
import java.util.List

import static org.junit.Assert.*
import static org.mockito.Mockito.*

public class MockitoSpyTest {

    @Test
    public void test() {
        // spy use a real ArrayList not like mock method
        // the arrayListSpy.add method will work
        // avoid use spy in real world project, better use mock
        List arrayListSpy = spy(ArrayList.class)
        assertEquals(0, arrayListSpy.size())

        // mocks return default value
        arrayListSpy.add("Dummy")
        verify(arrayListSpy).add("Dummy")
        verify(arrayListSpy, never()).clear()

        assertEquals(1, arrayListSpy.size())
    }
}