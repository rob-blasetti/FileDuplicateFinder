package duplicateFinder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by leng on 30/04/2014.
 */
public class FileStreamOpenerImplement implements FileStreamOpener {
    @Override
    public InputStream open(String path) throws FileNotFoundException {

        return new FileInputStream(new File(path));
    }
}
