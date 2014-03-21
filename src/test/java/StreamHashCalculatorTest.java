import Impletment.StreamHashCalculator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by leng on 19/03/2014.
 */
public class StreamHashCalculatorTest {

    private StreamHashCalculator streamHashCalculator;
    private ByteArrayInputStream inputStream;

    @Before
    public void setUp() {
        String content = "blah blah blah\n";
        byte[] buf = content.getBytes();
        inputStream = new ByteArrayInputStream(buf);
        streamHashCalculator = new StreamHashCalculator();

    }

    @Test
    public void shouldCalculateContentHash() {
        String content = "blah blah blah\n";
        byte[] buf = content.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buf);

        StreamHashCalculator hashCalculator = new StreamHashCalculator();

        Assert.assertEquals("e58d666df0d6cc6e87a7e48440d637e9", hashCalculator.generateHashCode(inputStream));
    }

    @Test
    public void shouldCalculateContentHashWhenThereIsNoContent() {
        String content = "";
        byte[] buf = content.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buf);

        StreamHashCalculator hashCalculator = new StreamHashCalculator();

        Assert.assertEquals("d41d8cd98f00b204e9800998ecf8427e", hashCalculator.generateHashCode(inputStream));
    }


}
