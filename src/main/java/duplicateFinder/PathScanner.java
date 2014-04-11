package duplicateFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leng on 11/04/2014.
 */
public class PathScanner {
    private List<String> listPath;

    public PathScanner() {
        listPath = new ArrayList<String>();
    }

    public List<String> getPaths(String directory) {
        scanDirectoryToGetFilePath(directory);
        return listPath;
    }

    private void scanDirectoryToGetFilePath(String directory) {
        File folder = new File(directory);
        File files[] = folder.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                scanDirectoryToGetFilePath(f.getAbsolutePath());
            } else {
                listPath.add(f.getAbsolutePath());
            }

        }
    }
}
