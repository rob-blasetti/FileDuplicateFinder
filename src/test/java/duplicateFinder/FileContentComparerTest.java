package duplicateFinder;

import duplicateFinder.FileContentComparer;
import duplicateFinder.FileStreamOpener;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by leng on 26/03/2014.
 */
public class FileContentComparerTest {
    private FileContentComparer fileContentComparer;
    FileStreamOpener fileStreamOpener;

    String content1 = "some content";
    String content2 = "some other content";

    String[] pathsWithContent1 = new String[]{
            "/content1/path1",
            "/content1/path2",
            "/content1/path3",
    };
    String[] pathsWithContent2 = new String[]{
            "/content2/path1",
            "/content2/path2"
    };

    InputStream[] streamsWithContent1;
    InputStream[] streamsWithContent2;

    @Before
    public void setUp() throws FileNotFoundException {

        fileStreamOpener = mock(FileStreamOpener.class);
        streamsWithContent1 = new InputStream[pathsWithContent1.length];

        for (int i = 0; i < pathsWithContent1.length; i++) {
            streamsWithContent1[i] = new ByteArrayInputStream(content1.getBytes());
            when(fileStreamOpener.open(pathsWithContent1[i])).thenReturn(streamsWithContent1[i]);
        }

        streamsWithContent2 = new InputStream[pathsWithContent2.length];
        for (int i = 0; i < pathsWithContent2.length; i++) {
            streamsWithContent2[i] = new ByteArrayInputStream(content2.getBytes());
            when(fileStreamOpener.open(pathsWithContent2[i])).thenReturn(streamsWithContent2[i]);
        }

        fileContentComparer = new FileContentComparer(fileStreamOpener);

    }

    @Test
    public void shouldReturnGroupofFileNamesThatAreDuplicatesOfEachOther() throws FileNotFoundException {
        String[] filePaths = new String[]{
                pathsWithContent1[0],
                pathsWithContent1[1],
                pathsWithContent1[2],
                pathsWithContent2[1],
                pathsWithContent2[0]
        };
        Assert.assertEquals(fileContentComparer.compareFiles(filePaths).size(), 2);


    }


    @Test
    public void shouldReturnNullWhenFilesAreNotDuplicateOfEachOther() throws FileNotFoundException {

        String[] arrayPath2 = new String[]{
                pathsWithContent1[0],
                pathsWithContent2[0],
        };

        Assert.assertEquals(fileContentComparer.compareFiles(arrayPath2), null);
    }
}
