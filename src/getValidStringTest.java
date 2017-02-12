import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * Created by yosuk on 2/11/2017.
 */
public class getValidStringTest {
    @Test
    public void getValidStringb() throws Exception {

        String[] strArray = {"r","c"};

        ByteArrayInputStream in = new ByteArrayInputStream("b".getBytes());
        System.setIn(in);

        assertEquals("b", InputValidator.getValidString(strArray));

    }

}