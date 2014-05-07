package duplicateFinder;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
        List<String> filePaths = new ArrayList<String>();
        filePaths.add("/directory/test/file1.txt");
        filePaths.add("/directory/test/file2.txt");
        when(pathScanner.getPaths("/directory/test")).thenReturn(filePaths);

        long fileSize = 100;
        when(fileSizeReader.readSize("/directory/test/file1.txt")).thenReturn(fileSize);
        when(fileSizeReader.readSize("/directory/test/file2.txt")).thenReturn(fileSize);

        String content = "This is test content which will mockup";

        InputStream streamContent = new ByteArrayInputStream(content.getBytes());
        when(fileStreamOpener.open("/directory/test/file1.txt")).thenReturn(streamContent);
        when(fileStreamOpener.open("/directory/test/file2.txt")).thenReturn(streamContent);


        // Wire-up
        StringOutputter outputter = new StringOutputter();
        FileClassifierBySize2 fileClassifierBySize = new FileClassifierBySize2(pathScanner, fileSizeReader);
        FileContentComparer fileContentComparer = new FileContentComparer(fileStreamOpener);

        DuplicateFinder duplicateFinder = new DuplicateFinder(outputter, fileClassifierBySize, fileContentComparer);
        duplicateFinder.scan("/directory/test");


        System.out.print(outputter.getResult());

        // Assertion


    }
}