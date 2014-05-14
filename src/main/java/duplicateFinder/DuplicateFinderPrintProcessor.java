package duplicateFinder;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by leng on 14/05/2014.
 */
public class DuplicateFinderPrintProcessor implements DuplicateFinderProcessor {

    private Outputter outputter;

    public DuplicateFinderPrintProcessor(Outputter outputter) {
        this.outputter = outputter;

    }

    @Override
    public void execute(HashMap<String, ArrayList<String>> dictionaryOfDuplicateFiles) throws FileNotFoundException {

        String result = new StringFormatter().formatData(dictionaryOfDuplicateFiles);
        outputter.writeLine(result);
    }
}
