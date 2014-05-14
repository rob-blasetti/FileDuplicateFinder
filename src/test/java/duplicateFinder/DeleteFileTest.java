package duplicateFinder;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by leng on 9/05/2014.
 */
public class DeleteFileTest {

    @Test
    public void shouldDeleteMethodWillRemoveGivenFile() {

        DeleteFile deleteFile = new DeleteFile();
        File file = mock(File.class);
        when(file.delete()).thenReturn(true);

        Assert.assertTrue(deleteFile.delete(file));

    }


}
