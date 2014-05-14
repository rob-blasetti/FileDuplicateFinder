package duplicateFinder;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by leng on 14/05/2014.
 */
public interface DuplicateFinderProcessor {


    void execute(HashMap<String, ArrayList<String>> dictionaryOfDuplicateFiles) throws FileNotFoundException;
}
