package duplicateFinder;

import junit.framework.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by leng on 30/04/2014.
 */
public class DuplicateFinderTest {

    @Test
    public void shouldScanMethodReturnDuplicateFiles() throws Exception {
        // Setup
        StringOutputter outputter = new StringOutputter();
        FileClassifierBySize fileClassifierBySize = mock(FileClassifierBySize.class);
        FileContentComparer fileContentComparer = mock(FileContentComparer.class);
        DuplicateFinderProcessor duplicateFinderProcessor = new DuplicateFinderPrintProcessor(outputter);

        // do some set up of the mocks
        HashMap<String, ArrayList<String>> dictionaryOfFileClassifiedBySize = new HashMap<String, ArrayList<String>>();
        ArrayList<String> filePaths = new ArrayList<String>();
        filePaths.add("/path/to/test-data/1.png");
        filePaths.add("/path/to/test-data/2.png");
        dictionaryOfFileClassifiedBySize.put("4199", filePaths);
        when(fileClassifierBySize.scanDirectory("/path/to/test-data")).thenReturn(dictionaryOfFileClassifiedBySize);


        HashMap<String, ArrayList<String>> dictionaryOfFileClassifiedByHash = new HashMap<String, ArrayList<String>>();
        dictionaryOfFileClassifiedByHash.put("163c2fa3861bad8c906e73580d6b8686", filePaths);

        when(fileContentComparer.compareFiles(filePaths.toArray(new String[filePaths.size()]))).thenReturn(dictionaryOfFileClassifiedByHash);


        DuplicateFinder duplicateFinder = new DuplicateFinder(duplicateFinderProcessor, fileClassifierBySize, fileContentComparer);

        // Action
        duplicateFinder.scan("/path/to/test-data");

        // Assertion
        String expectedOutput = "=====================================================\n" +
                "/path/to/test-data/1.png\n" +
                "/path/to/test-data/2.png\n";

        Assert.assertEquals(expectedOutput, outputter.getResult());

    }

}
