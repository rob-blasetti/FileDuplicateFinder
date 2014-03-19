import HashingMD5.HashingMD5;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by leng on 19/03/2014.
 */
public class HashingMD5Test {

    private HashingMD5 hashingMD5;

    @Before
    public void setUp() {
        FileInputStream file = null;
        try {
            String workingDir = System.getProperty("user.dir");

            String filePath = workingDir + "/src/main/resources/someArrays";

            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        hashingMD5 = new HashingMD5();
        hashingMD5.setFile(file);

    }

    @Test
    public void check32Length() {

        Assert.assertEquals(hashingMD5.generateHashCode().length(), 32);

    }

    @Test
    public void checkHashingNull() {
        Assert.assertFalse(hashingMD5.generateHashCode() == null);

    }

    @Test
    public void checkFileIsTheSame() {
        Assert.assertEquals(hashingMD5.generateHashCode(), "9FC9253E2DBE5E53BD98AFB8BE477697".toLowerCase());
    }


}
