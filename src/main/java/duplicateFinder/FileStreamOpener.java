package duplicateFinder;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by leng on 28/03/2014.
 */
public interface FileStreamOpener {
    public InputStream open(String path) throws FileNotFoundException;
}
