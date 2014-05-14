package duplicateFinder;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by leng on 14/05/2014.
 */
public class DuplicateFinderPrintProcessorTest {

    @Test
    public void shouldExecuteMethodDeleteDuplicateFile() throws Exception {
        // Setup
        StringOutputter outputter = new StringOutputter();
        FileDeleter fileDeleter = new FileDeleter();
        FileClassifierBySize fileClassifierBySize = mock(FileClassifierBySize.class);
        FileContentComparer fileContentComparer = mock(FileContentComparer.class);

        // do some set up of the mocks
        HashMap<String, ArrayList<String>> dictionaryOfDuplicateFiles = new HashMap<String, ArrayList<String>>();
        ArrayList<String> filePaths = new ArrayList<String>();
        filePaths.add("/path/to/test-data/1.png");
        filePaths.add("/path/to/test-data/2.png");
        dictionaryOfDuplicateFiles.put("163c2fa3861bad8c906e73580d6b8686", filePaths);


        DuplicateFinderPrintProcessor duplicateFinderPrintProcessor = new DuplicateFinderPrintProcessor(outputter);

        // Action
        duplicateFinderPrintProcessor.execute(dictionaryOfDuplicateFiles);

        // Assertion
        String expectedOutput = "=====================================================\n" +
                "/path/to/test-data/1.png\n" +
                "/path/to/test-data/2.png\n";

        Assert.assertEquals(expectedOutput, outputter.getResult());
    }
}
