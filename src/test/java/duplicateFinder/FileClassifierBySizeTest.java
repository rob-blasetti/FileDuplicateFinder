package duplicateFinder;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/04/2014
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */


public class FileClassifierBySizeTest {
    private FileClassifierBySize fileClassifierBySize;
    private String content1 = "working with mock";
    private File mockFile;

    @Before
    public void setUp() {
        fileClassifierBySize = new FileClassifierBySize();
        mockFile = mock(File.class);
        when(mockFile.getAbsolutePath()).thenReturn("/User/mockdir");
        File files[] = new File[5];
        for (int i = 0; i < 5; i++) {
            if (i < 2) {
                File temporaryFile = mock(File.class);
                when(temporaryFile.length()).thenReturn(Long.parseLong("12"));
                when(temporaryFile.getAbsolutePath()).thenReturn("/User/mockdir/file1");
                files[i] = temporaryFile;
            } else {
                File temporaryFile = mock(File.class);
                when(temporaryFile.length()).thenReturn(Long.parseLong("13"));
                when(temporaryFile.getAbsolutePath()).thenReturn("/User/mockdir/file1" + i);
                files[i] = temporaryFile;


            }
        }
        when(mockFile.listFiles()).thenReturn(files);


    }

    @Test
    public void shouldGroupFilesBySizeReturnExpectedDictionary() {

        HashMap<String, ArrayList<String>> result = fileClassifierBySize.scanDirectory(mockFile);
        for (String key : result.keySet()) {
            System.out.println("========= :" + key);
            for (String path : result.get(key)) {
                System.out.println(path);
            }
        }

        Assert.assertEquals(fileClassifierBySize.scanDirectory(mockFile).size(), 2);

    }

    @Test
    public void shouldGroupFileBySizeReturnNullWhenEmptyPathIsGiven() {
        Assert.assertEquals(fileClassifierBySize.scanDirectory(null), null);
    }

}