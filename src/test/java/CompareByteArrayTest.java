import Impletment.CompareByteArray;
import Impletment.FileDuplicateFinderByteReader;
import Interface.CompareFileImp;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leng on 14/03/2014.
 */
public class CompareByteArrayTest {

    @Test
    public void testAreContentSame() {


        String workingDir = System.getProperty("user.dir");
        String filePath = workingDir + "/src/main/resources/someArrays";
        String filePath2 = workingDir + "/src/main/resources/someArrays2";

        FileDuplicateFinderByteReader fileDuplicateFinderByteReader = new FileDuplicateFinderByteReader(filePath);

        byte[] byte1 = fileDuplicateFinderByteReader.readFileByte();

        fileDuplicateFinderByteReader.setFilePath(filePath2);
        byte[] byte2 = fileDuplicateFinderByteReader.readFileByte();
        CompareFileImp compareByteArray = new CompareByteArray(byte1, byte2);


        Assert.assertTrue(compareByteArray.areContentSame());

//        Assert.assertFalse(compareByteArray.areContentSame());
    }
}
