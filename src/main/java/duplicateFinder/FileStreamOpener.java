package duplicateFinder;

import java.io.InputStream;

/**
 * Created by leng on 28/03/2014.
 */
public interface FileStreamOpener {
    InputStream open(String path);
}
