package duplicateFinder;

import java.io.File;

/**
 * Created by leng on 11/04/2014.
 */
public class FileSizeReader {
    public long readSize(String path) {
        return new File(path).length();
    }
}
