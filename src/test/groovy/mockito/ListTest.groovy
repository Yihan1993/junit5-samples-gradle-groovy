package mockito

import static groovy.test.GroovyAssert.*
import org.junit.Test
import java.util.List
import static org.mockito.Mockito.*

public class ListTest {

    @Test
    public void testMockListSize() {
        List listMock = mock(List.class)
        when(listMock.size()).thenReturn(2)

        assertEquals(2, listMock.size())
    }

    @Test
    public void testMockListSize_ReturnMultipleValues() {
        List listMock = mock(List.class)
        when(listMock.size()).thenReturn(2).thenReturn(3)

        assertEquals(2, listMock.size())
        assertEquals(3, listMock.size())
    }

    @Test
    public void testMockListGet() {
        List listMock = mock(List.class)
        // when(listMock.get(0)).thenReturn("hello world")
        when(listMock.get(anyInt())).thenReturn("hello world")

        assertEquals("hello world", listMock.get(0))
        // assertEquals(null, listMock.get(1))
        assertEquals("hello world", listMock.get(1))

    }
}