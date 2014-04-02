import Impletment.StringOutputter;
import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leng on 2/04/2014.
 */
public class StringOutputterTest {

    String result;
    StringOutputter stringOutputter;
    @Before
    public void setup(){
        result = "test";
        stringOutputter = new StringOutputter();
        stringOutputter.writeLine(result);
    }

    @Test
    public void shouldOutputFormattedString(){
        Assert.assertTrue(result.equals(stringOutputter.getResult()));
    }

}
