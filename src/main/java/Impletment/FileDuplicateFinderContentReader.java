package Impletment;

import Interface.FileDuplicateFinderContentReaderImp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 12/03/2014
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileDuplicateFinderContentReader implements FileDuplicateFinderContentReaderImp {
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public FileDuplicateFinderContentReader(String filePath) {
        this.filePath = filePath;

    }

    public List<String> readFileContent() {

        List<String> fileContentList = new ArrayList<String>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContentList.add(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();

        }

        return fileContentList;
    }
}
