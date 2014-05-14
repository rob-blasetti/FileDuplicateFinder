package duplicateFinder;

import org.omg.DynamicAny._DynEnumStub;

import java.io.File;

/**
 * Created by leng on 9/05/2014.
 */
public class FileDeleter {


    public boolean delete(File file) {
        if (file == null) {
            return false;
        }
        if (file.delete()) {
            return true;
        } else {
            return false;
        }
    }
}
