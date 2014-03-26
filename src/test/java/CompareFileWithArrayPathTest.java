import Impletment.CompareFileWithArrayPath;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by leng on 26/03/2014.
 */
public class CompareFileWithArrayPathTest {
    private CompareFileWithArrayPath compareFileWithArrayPath;


    @Before
    public void setUp() {
        compareFileWithArrayPath = new CompareFileWithArrayPath();


    }

    @Test
    public void doesComparisonReturnArray() throws FileNotFoundException {
        String[] arrayPath = new String[3];
        arrayPath[0] = "/Users/leng/Desktop/photo/1.png";
        arrayPath[1] = "/Users/leng/Desktop/photo/11.png";
        arrayPath[2] = "/Users/leng/Desktop/photo/3.png";


        Assert.assertEquals(compareFileWithArrayPath.compareFiles(arrayPath).size(), 2);
    }

    @Test
    public void comparisonReturnNull() throws FileNotFoundException {

        String[] arrayPath2 = new String[3];
        arrayPath2[0] = "/Users/leng/Desktop/photo/1.png";
        arrayPath2[1] = "/Users/leng/Desktop/photo/2.png";
        arrayPath2[2] = "/Users/leng/Desktop/photo/3.png";

        Assert.assertEquals(compareFileWithArrayPath.compareFiles(arrayPath2), null);
    }
}
