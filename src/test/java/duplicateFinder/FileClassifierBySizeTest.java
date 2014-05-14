package duplicateFinder;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by leng on 11/04/2014.
 */
public class FileClassifierBySizeTest {
    FileSizeReader fileSizeReader;
    PathScanner pathScanner;

    @Before
    public void setUp() {
        fileSizeReader = mock(FileSizeReader.class);
        pathScanner = mock(PathScanner.class);
        List<String> paths = new ArrayList<String>();
        paths.add("/path1/file1");
        paths.add("/path1/file2");
        paths.add("/path1/p/file3");
        paths.add("/path1/p/file4");
        when(pathScanner.getPaths("/path1")).thenReturn(paths);
        for (int i = 0; i < pathScanner.getPaths("/path1").size(); i++) {
            if (i < 2) {
                when(fileSizeReader.readSize(paths.get(i))).thenReturn(Long.parseLong("123"));
            } else {
                when(fileSizeReader.readSize(paths.get(i))).thenReturn(Long.parseLong("1235"));
            }

        }

    }

    @Test
    public void shouldClassifyFilesInFolderBySize() {


        FileClassifierBySize fileClassifierBySize = new FileClassifierBySize(pathScanner, fileSizeReader);

        HashMap<String, ArrayList<String>> result = fileClassifierBySize.scanDirectory("/path1");

        Assert.assertEquals(2, result.size());

        String size1 = "123";
        Assert.assertEquals("/path1/file1", result.get(size1).get(0));
        Assert.assertEquals("/path1/file2", result.get(size1).get(1));

        String size2 = "1235";
        Assert.assertEquals("/path1/p/file3", result.get(size2).get(0));
        Assert.assertEquals("/path1/p/file4", result.get(size2).get(1));
    }
}
