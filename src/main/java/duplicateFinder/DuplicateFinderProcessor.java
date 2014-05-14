package duplicateFinder;

import java.io.FileNotFoundException;

/**
 * Created by leng on 14/05/2014.
 */
public interface DuplicateFinderProcessor {
    void execute(String pathToScan) throws FileNotFoundException;
}
