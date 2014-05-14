package duplicateFinder;

import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by leng on 14/05/2014.
 */
public class DuplicateFinderDeleteProcessorTest {

    @Test
    public void shouldExecuteMethodDeleteDuplicateFile() throws Exception {
        // Setup
        FileDeleter fileDeleter = mock(FileDeleter.class);
        StringOutputter outputter = new StringOutputter();

        // do some set up of the mocks
        HashMap<String, ArrayList<String>> dictionaryOfDuplicateFiles = new HashMap<String, ArrayList<String>>();
        ArrayList<String> filePaths = new ArrayList<String>();
        filePaths.add("/path/to/test-data/1.png");
        filePaths.add("/path/to/test-data/2.png");
        filePaths.add("/path/to/test-data/3.png");
        filePaths.add("/path/to/test-data/4.png");
        filePaths.add("/path/to/test-data/5.png");
        dictionaryOfDuplicateFiles.put("41934349", filePaths);

        when(fileDeleter.delete(new File("/path/to/test-data/2.png"))).thenReturn(true);
        when(fileDeleter.delete(new File("/path/to/test-data/3.png"))).thenReturn(true);
        when(fileDeleter.delete(new File("/path/to/test-data/4.png"))).thenReturn(true);
        when(fileDeleter.delete(new File("/path/to/test-data/5.png"))).thenReturn(true);


        DuplicateFinderDeleteProcessor duplicateFinderDeleteProcessor = new DuplicateFinderDeleteProcessor(fileDeleter, outputter);

        // Action
        duplicateFinderDeleteProcessor.execute(dictionaryOfDuplicateFiles);

        String expectedResult = "/path/to/test-data/2.png\n" +
                "/path/to/test-data/3.png\n" +
                "/path/to/test-data/4.png\n" +
                "/path/to/test-data/5.png\n";

        // Assertion
        Assert.assertEquals(expectedResult, outputter.getResult());

    }
}
