package duplicateFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by leng on 11/04/2014.
 */
public class FileClassifierBySize2 {

    private PathScanner pathScanner;
    private FileSizeReader fileSizeReader;

    public FileClassifierBySize2(PathScanner pathScanner, FileSizeReader fileSizeReader) {
        this.pathScanner = pathScanner;
        this.fileSizeReader = fileSizeReader;
    }

    public HashMap<String, ArrayList<String>> scanDirectory(String directory) {
        HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();

        List<String> paths = pathScanner.getPaths(directory);

        for (String path : paths) {
            classifyPath(path, result);
        }

        return result;
    }

    private void classifyPath(String path, HashMap<String, ArrayList<String>> result) {
        long size = fileSizeReader.readSize(path);
        String sizeAsString = String.valueOf(size);
        if (!result.containsKey(sizeAsString)) {
            result.put(sizeAsString, new ArrayList<String>());
        }
        result.get(sizeAsString).add(path);
    }
}
