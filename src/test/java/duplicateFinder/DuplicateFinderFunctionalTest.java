package duplicateFinder;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by leng on 2/05/2014.
 */
public class DuplicateFinderFunctionalTest {
    @Test
    public void shouldScanMethodReturnDuplicateFiles() throws Exception {
        //Mock
        PathScanner pathScanner = mock(PathScanner.class);
        FileSizeReader fileSizeReader = mock(FileSizeReader.class);
        FileStreamOpener fileStreamOpener = mock(FileStreamOpener.class);


        //Setup Mocking
        ArrayList<String> filePaths = new ArrayList<String>();
        filePaths.add("/directory/test/file1.txt");
        filePaths.add("/directory/test/file2.txt");
        when(pathScanner.getPaths("/directory/test")).thenReturn(filePaths);

        long fileSize = 100;
        when(fileSizeReader.readSize("/directory/test/file1.txt")).thenReturn(fileSize);
        when(fileSizeReader.readSize("/directory/test/file2.txt")).thenReturn(fileSize);

        String content = "This is test content which will mockup";

        when(fileStreamOpener.open("/directory/test/file1.txt")).thenReturn(new ByteArrayInputStream(content.getBytes()));
        when(fileStreamOpener.open("/directory/test/file2.txt")).thenReturn(new ByteArrayInputStream(content.getBytes()));


        // Wire-up
        StringOutputter outputter = new StringOutputter();
        DuplicateFinderProcessor duplicateFinderProcessor = new DuplicateFinderPrintProcessor(outputter);
        FileClassifierBySize fileClassifierBySize = new FileClassifierBySize(pathScanner, fileSizeReader);
        FileContentComparer fileContentComparer = new FileContentComparer(fileStreamOpener);


        DuplicateFinder duplicateFinder = new DuplicateFinder(duplicateFinderProcessor, fileClassifierBySize, fileContentComparer);
        duplicateFinder.scan("/directory/test");


        String expectedResult = "=====================================================\n" +
                "/directory/test/file1.txt\n" +
                "/directory/test/file2.txt\n";
        Assert.assertEquals(expectedResult, outputter.getResult());

        // Assertion


    }
}
