package duplicateFinder;

import java.io.File;

/**
 * Created by leng on 9/05/2014.
 */
public class FileOpenerImplement implements FileOpener {
    @Override
    public File open(String filePath) {
        return new File(filePath);
    }
}
