package duplicateFinder;

import junit.framework.Assert;
import org.junit.Test;

import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by leng on 9/05/2014.
 */
public class FileDeleterTest {

    @Test
    public void shouldDeleteMethodWillRemoveGivenFile() {

        FileDeleter fileDeleter = new FileDeleter();
        File file = mock(File.class);
        when(file.delete()).thenReturn(true);

        Assert.assertTrue(fileDeleter.delete(file));

    }


}
